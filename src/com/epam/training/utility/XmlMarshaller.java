package com.epam.training.utility;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class XmlMarshaller {
	private String xmlFile;
	private Object obj;
	private final String MARSHAL_DONE = "Marshal done :";
	private final static String ERR = "Error xml marshall. App terminated.";

	public XmlMarshaller(String xmlFile, Object obj) {
		super();
		this.xmlFile = xmlFile;
		this.obj = obj;
	}

	public void doMarshall() throws IOException {
		try {

			File file = new File(xmlFile);
			JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			System.out.println(MARSHAL_DONE);
			jaxbMarshaller.marshal(obj, file);
			jaxbMarshaller.marshal(obj, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
			throw new IOException(ERR);
		}
	}
}