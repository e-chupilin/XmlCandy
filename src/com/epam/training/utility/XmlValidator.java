package com.epam.training.utility;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XmlValidator {
	private String xmlSchema;
	private String xmlFile;
	private String xsdFile;
	private String USE_SCHEMA = "Use schema: ";
	private final static String XML_FILE_IS_VALID = "File is valid: ";
	private final static String XML_FILE_NOT_VALID = " is not valid : ";
	private final static String ERR = "Error xml validate. App terminated.";

	public XmlValidator(String xmlSchema, String xmlFile, String xsdFile) {
		super();
		this.xmlSchema = xmlSchema;
		this.xmlFile = xmlFile;
		this.xsdFile = xsdFile;
	}

	public void check() throws SAXException, IOException {
		SchemaFactory factory = SchemaFactory.newInstance(xmlSchema);
		File schemaLocation = new File(xsdFile);
		Schema schema = factory.newSchema(schemaLocation);

		Validator validator = schema.newValidator();

		Source source = new StreamSource(xmlFile);
		System.out.println(USE_SCHEMA + xsdFile);

		try {
			validator.validate(source);
			System.out.println(XML_FILE_IS_VALID + xmlFile);
		} catch (SAXException ex) {
			System.out.println(xmlFile + XML_FILE_NOT_VALID + ex.getMessage());	
			throw new IOException(ERR);
		}
	}
}
