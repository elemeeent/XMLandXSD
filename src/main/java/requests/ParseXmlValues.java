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

    private static String orderPersonValue;
    private static String shipToNameValue;
    private static String shipToAddressValue;
    private static String shipToCityValue;
    private static String shipToCountryValue;
    private static String itemTitleValue;
    private static String itemNoteValue;
    private static String itemQuantityValue;
    private static String itemPriceValue;


    public static void parseXmlFile(File xmlFile) {
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.parse(xmlFile);

            NodeList orderPersonList = doc.getElementsByTagName("orderperson");
            for (int i = 0; i < orderPersonList.getLength(); i++) {
                Node orderPersonNode = orderPersonList.item(i);
                orderPersonValue = orderPersonNode.getTextContent();
            }


            NodeList shipToList = doc.getElementsByTagName("shipto");
            for (int i = 0; i < shipToList.getLength(); i++) {
                Node shipToNode = shipToList.item(i);
                if (shipToNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) shipToNode;
                    shipToNameValue = element.getElementsByTagName("name").item(0).getTextContent();
                    shipToAddressValue = element.getElementsByTagName("address").item(0).getTextContent();
                    shipToCityValue = element.getElementsByTagName("city").item(0).getTextContent();
                    shipToCountryValue = element.getElementsByTagName("country").item(0).getTextContent();
                }
            }

            NodeList itemList = doc.getElementsByTagName("item");
            for (int i = 0; i < itemList.getLength(); i++) {
                Node itemNode = itemList.item(i);
                if (itemNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) itemNode;
                    itemTitleValue = element.getElementsByTagName("title").item(0).getTextContent();
                    itemNoteValue = element.getElementsByTagName("note").item(0).getTextContent();
                    itemQuantityValue = element.getElementsByTagName("quantity").item(0).getTextContent();
                    itemPriceValue = element.getElementsByTagName("price").item(0).getTextContent();
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

    public static String getOrderPersonValue() {
        return orderPersonValue;
    }

    public static String getShipToNameValue() {
        return shipToNameValue;
    }

    public static String getShipToAddressValue() {
        return shipToAddressValue;
    }

    public static String getShipToCityValue() {
        return shipToCityValue;
    }

    public static String getShipToCountryValue() {
        return shipToCountryValue;
    }

    public static String getItemTitleValue() {
        return itemTitleValue;
    }

    public static String getItemNoteValue() {
        return itemNoteValue;
    }

    public static String getItemQuantityValue() {
        return itemQuantityValue;
    }

    public static String getItemPriceValue() {
        return itemPriceValue;
    }
}