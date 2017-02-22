package requests;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import org.w3c.dom.Document;

public class ParseXmlValues {


    public static void parseXmlFile(File xmlFile) {
        XmlValues xmlValues = new XmlValues();
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.parse(xmlFile);

            NodeList orderPersonList = doc.getElementsByTagName("orderperson");
            for (int i = 0; i < orderPersonList.getLength(); i++) {
                Node orderPersonNode = orderPersonList.item(i);
                xmlValues.setOrderPersonValue(orderPersonNode.getTextContent());
            }


            NodeList shipToList = doc.getElementsByTagName("shipto");
            for (int i = 0; i < shipToList.getLength(); i++) {
                Node shipToNode = shipToList.item(i);
                if (shipToNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) shipToNode;
                    xmlValues.setShipToNameValue(element.getElementsByTagName("name").item(0).getTextContent());
                    xmlValues.setShipToAddressValue(element.getElementsByTagName("address").item(0).getTextContent());
                    xmlValues.setShipToCityValue(element.getElementsByTagName("city").item(0).getTextContent());
                    xmlValues.setShipToCountryValue(element.getElementsByTagName("country").item(0).getTextContent());
                }
            }

            NodeList itemList = doc.getElementsByTagName("item");
            for (int i = 0; i < itemList.getLength(); i++) {
                Node itemNode = itemList.item(i);
                if (itemNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) itemNode;
                    xmlValues.setItemTitleValue(element.getElementsByTagName("title").item(0).getTextContent());
                    xmlValues.setItemNoteValue(element.getElementsByTagName("note").item(0).getTextContent());
                    xmlValues.setItemQuantityValue(element.getElementsByTagName("quantity").item(0).getTextContent());
                    xmlValues.setItemPriceValue(element.getElementsByTagName("price").item(0).getTextContent());
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}