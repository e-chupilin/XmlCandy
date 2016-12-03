package com.epam.training.utility;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.example.Candys;
import com.example.candy.CandyType;

public class XmlStaxWriter {
	private final static String STAX_START = "Stax start write to : ";
	private final static String STAX_END = "Stax work end. ";
	private final static String NEW_LINE = "/n";
	private final static String ERR = "Error xml stax write. App terminated.";
	private final static String ENCODING = "UTF-8";
	private final static String XML_VER = "1.0";
	private final static String START_ELEMENT = "candys";
	private final static String CANDY_ELEMENT = "candy";
	private final static String NAME_ELEMENT = "name";
	private final static String CALORIC_ELEMENT = "caloric-value";
	private final static String TYPE_ELEMENT = "type";
	private final static String PROTEINS_ELEMENT = "proteins";
	private final static String INGREDIENTS_ELEMENT = "ingredients";
	private final static String NUTRITIONAL_ELEMENT = "nutritional-value";
	private final static String FATS_ELEMENT = "fats";
	private final static String CARBOHYDRATE_ELEMENT = "carbohydrates";
	private final static String MANUFARTURE_ELEMENT = "venture-manufacturer";

	private final static String WATER_ATTR = "water";
	private final static String SUGAR_ATTR = "sugar";
	private final static String FRUCTOSE_ATTR = "fructose";
	private final static String CHOCO_TYPE_ATTR = "choco-type";
	private final static String VANILLIN_ATTR = "vanillin";

	private final static String XMLNS = "xmlns";
	private final static String XMLNS_NAMESPACE = "http://www.example.com";
	private final static String XMLNS_XSI = "xsi";
	private final static String XMLNS_XSI_NAMESPACE = "http://www.w3.org/2001/XMLSchema-instance";
	private final static String XSI_SCHEMA_LOC = "xsi:schemaLocation";
	private final static String XSI_SCHEMA_LOC_NAMESPACE = "http://www.example.com Candys.xsd";
	private final static String XMLNS_TNS = "tns";
	private final static String XMLNS_TNS_NAMESPACE = "http://www.example.com/candy";

	private String xmlFile;
	Candys candys;

	public XmlStaxWriter(String xmlFile, Candys candys) {
		super();
		this.xmlFile = xmlFile;
		this.candys = candys;
	}

	public void doXmlStaxWrite() throws IOException {
		XMLOutputFactory xmlFactory = XMLOutputFactory.newInstance();

		try {
			System.out.println(STAX_START + xmlFile);
			XMLStreamWriter xmlWriter = xmlFactory.createXMLStreamWriter(new FileOutputStream(xmlFile), ENCODING);
			Collection<CandyType> listCandys = candys.getCandy();
			xmlWriter.writeStartDocument(ENCODING, XML_VER);
			xmlWriter.writeStartElement(START_ELEMENT);
			xmlWriter.writeNamespace(XMLNS, XMLNS_NAMESPACE);
			xmlWriter.writeNamespace(XMLNS_XSI, XMLNS_XSI_NAMESPACE);
			xmlWriter.writeAttribute(XSI_SCHEMA_LOC, XSI_SCHEMA_LOC_NAMESPACE);
			xmlWriter.writeNamespace(XMLNS_TNS, XMLNS_TNS_NAMESPACE);

			for (CandyType candy : listCandys) {
				xmlWriter.writeStartElement(CANDY_ELEMENT);
				xmlWriter.writeStartElement(XMLNS_TNS, NAME_ELEMENT, XMLNS_TNS_NAMESPACE);
				xmlWriter.writeCharacters(candy.getName());
				xmlWriter.writeEndElement();
				xmlWriter.writeStartElement(XMLNS_TNS, CALORIC_ELEMENT, XMLNS_TNS_NAMESPACE);
				xmlWriter.writeCharacters(String.valueOf(candy.getCaloricValue()));
				xmlWriter.writeEndElement();
				xmlWriter.writeStartElement(XMLNS_TNS, TYPE_ELEMENT, XMLNS_TNS_NAMESPACE);
				xmlWriter.writeCharacters(candy.getType().toUpperCase());
				xmlWriter.writeEndElement();
				xmlWriter.writeStartElement(XMLNS_TNS, INGREDIENTS_ELEMENT, XMLNS_TNS_NAMESPACE);
				xmlWriter.writeAttribute(WATER_ATTR, String.valueOf(candy.getIngredients().getWater()));
				xmlWriter.writeAttribute(SUGAR_ATTR, String.valueOf(candy.getIngredients().getSugar()));
				xmlWriter.writeAttribute(FRUCTOSE_ATTR, String.valueOf(candy.getIngredients().getFructose()));
				if (candy.getIngredients().getChocoType() != null)
					xmlWriter.writeAttribute(CHOCO_TYPE_ATTR, candy.getIngredients().getChocoType());
				xmlWriter.writeAttribute(VANILLIN_ATTR, String.valueOf(candy.getIngredients().getVanillin()));
				xmlWriter.writeEndElement();

				xmlWriter.writeStartElement(XMLNS_TNS, NUTRITIONAL_ELEMENT, XMLNS_TNS_NAMESPACE);

				xmlWriter.writeStartElement(XMLNS_TNS, PROTEINS_ELEMENT, XMLNS_TNS_NAMESPACE);
				xmlWriter.writeCharacters(candy.getNutritionalValue().getProteins());
				xmlWriter.writeEndElement();

				xmlWriter.writeStartElement(XMLNS_TNS, FATS_ELEMENT, XMLNS_TNS_NAMESPACE);
				xmlWriter.writeCharacters(candy.getNutritionalValue().getFats());
				xmlWriter.writeEndElement();

				xmlWriter.writeStartElement(XMLNS_TNS, CARBOHYDRATE_ELEMENT, XMLNS_TNS_NAMESPACE);
				xmlWriter.writeCharacters(candy.getNutritionalValue().getCarbohydrates());
				xmlWriter.writeEndElement();

				xmlWriter.writeEndElement();

				xmlWriter.writeStartElement(XMLNS_TNS, MANUFARTURE_ELEMENT, XMLNS_TNS_NAMESPACE);
				xmlWriter.writeCharacters(String.valueOf(candy.getVentureManufacturer()));
				xmlWriter.writeEndElement();

				xmlWriter.writeEndElement();
			}

			xmlWriter.writeEndElement();
			xmlWriter.writeEndDocument();

			xmlWriter.flush();
			xmlWriter.close();

			System.out.println(STAX_END);

		} catch (XMLStreamException | IOException e) {
			e.printStackTrace();
			throw new IOException(ERR);
		}
	}
}