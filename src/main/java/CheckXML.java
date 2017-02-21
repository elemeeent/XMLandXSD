import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CheckXML {
    public static boolean verifyXmlByXsd(File xmlFile, File xsdFile) {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            final FileInputStream fileInputStream = new FileInputStream(xmlFile);
            try {
                Schema schema = schemaFactory.newSchema(xsdFile);
                Validator validator = schema.newValidator();
                validator.validate(new StreamSource(fileInputStream));
                return true;
            } catch (SAXException e1) {
                e1.printStackTrace();
                return false;
            } catch (IOException e1) {
                e1.printStackTrace();
                return false;
            } finally {
                fileInputStream.close();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
            return false;
        }
    }
}
