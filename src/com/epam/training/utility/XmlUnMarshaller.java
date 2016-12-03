package com.epam.training.utility;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.example.Candys;
import com.example.candy.CandyType;

public class XmlUnMarshaller {
	private String xmlFile;
	private Class<Candys> xmlClass;
	private final String UNMARSHAL_DONE = "Unmarshal done. \nElements name for example :";
	private final static String ERR = "Error xml unmarshall. App terminated.";

	public XmlUnMarshaller(String xmlFile, Class<Candys> xmlClass) {
		super();
		this.xmlFile = xmlFile;
		this.xmlClass = xmlClass;
	}

	public Candys doXmlUnMarshall() throws IOException {
		try {
			File file = new File(xmlFile);
			JAXBContext jaxbContext = JAXBContext.newInstance(xmlClass);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Candys candys = (Candys) jaxbUnmarshaller.unmarshal(file);
			
			System.out.println(UNMARSHAL_DONE);

			Collection<CandyType> listCandys = candys.getCandy();
			for (CandyType candy : listCandys) {
				System.out.println(candy.getName());
			}
			return candys;
		} catch (JAXBException e) {
			e.printStackTrace();
			throw new IOException(ERR);
		}
	}
}