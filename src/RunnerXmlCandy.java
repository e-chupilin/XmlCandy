import java.io.*;
import org.xml.sax.SAXException;

import com.epam.training.utility.XmlMarshaller;
import com.epam.training.utility.XmlStaxWriter;
import com.epam.training.utility.XmlUnMarshaller;
import com.epam.training.utility.XmlValidator;
import com.example.Candys;
import static com.epam.training.constant.Constants.*;

public class RunnerXmlCandy {
	public final static String DELIMITER = "-----";
	public final static String NEW_XML_STAX_CHECK = "Verify new xml creating by stax :";

	public static void main(String[] args) {
		try {

			XmlValidator validator = new XmlValidator(XML_SCHEMA, XML_FILE, XSD_FILE);
			validator.check();
			System.out.println(DELIMITER);

			XmlUnMarshaller unMarsh = new XmlUnMarshaller(XML_FILE, Candys.class);
			Candys newCandys = unMarsh.doXmlUnMarshall();
			System.out.println(DELIMITER);

			XmlMarshaller xmlMarsh = new XmlMarshaller(XML_FILE_MARSH_TEST, newCandys);
			xmlMarsh.doMarshall();
			System.out.println(DELIMITER);

			XmlStaxWriter xmlStax = new XmlStaxWriter(XML_FILE_STAX_TEST, newCandys);
			xmlStax.doXmlStaxWrite();
			System.out.println(DELIMITER);

			System.out.println(NEW_XML_STAX_CHECK);
			XmlValidator validatorStaxFile = new XmlValidator(XML_SCHEMA, XML_FILE_CREATE_BY_STAX, XSD_FILE);
			validatorStaxFile.check();

		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}
	}
}