package requests;

import tables.ItemTable;
import tables.OrderPersonTable;
import tables.ShipToTable;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class InsertRequest {

    public static void insertToItemTable(Connection con) {

        Statement statement = null;
        ItemTable itemTable = new ItemTable();
        String valueToItemTableRequest = "INSERT INTO "
                + itemTable.getTableItem() + " ("
                + itemTable.getItemTitleValue() + ", "
                + itemTable.getItemNoteValue() + ", "
                + itemTable.getItemQuantityValue() + ", "
                + itemTable.getItemPriceValue() + ") "
                + "VALUES "
                + "("
                + "'" + ParseXmlValues.getItemTitleValue() + "', "
                + "'" + ParseXmlValues.getItemNoteValue() + "', "
                + "'" +ParseXmlValues.getItemQuantityValue() + "', "
                + ParseXmlValues.getItemPriceValue() + ")";

        try {
            System.out.println(valueToItemTableRequest);
            statement = con.createStatement();
            statement.executeUpdate(valueToItemTableRequest);
            System.out.println("Record is inserted to " + itemTable.getTableItem() + " table");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void insertToOrderPersonTable(Connection con) {

        Statement statement = null;
        OrderPersonTable orderPersonTable = new OrderPersonTable();
        String valueToItemTableRequest = "INSERT INTO "
                + orderPersonTable.getTableOrderPerson() + " ("
                + orderPersonTable.getOrderPersonNameValue() + ") "
                + "VALUES "
                + "("
                + "'" + ParseXmlValues.getOrderPersonValue() + "'"
                + ")";

        try {
            System.out.println(valueToItemTableRequest);
            statement = con.createStatement();
            statement.executeUpdate(valueToItemTableRequest);
            System.out.println("Record is inserted to " + orderPersonTable.getTableOrderPerson() + " table");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void insertToShipToTable(Connection con) {

        Statement statement = null;
        ShipToTable shipToTable = new ShipToTable();
        String valueToItemTableRequest = "INSERT INTO "
                + shipToTable.getTableShipTo() + " ("
                + shipToTable.getShipToNameValue() + ", "
                + shipToTable.getShipToAddressValue() + ", "
                + shipToTable.getShipToCityValue() + ", "
                + shipToTable.getShipToCountryValue() + ") "
                + "VALUES "
                + "("
                + "'" + ParseXmlValues.getShipToNameValue() + "', "
                + "'" + ParseXmlValues.getShipToAddressValue() + "', "
                + "'" + ParseXmlValues.getShipToCityValue() + "', "
                + "'" + ParseXmlValues.getShipToCountryValue() + "'"
                + ")";

        try {
            System.out.println(valueToItemTableRequest);
            statement = con.createStatement();
            statement.executeUpdate(valueToItemTableRequest);
            System.out.println("Record is inserted to " + shipToTable.getTableShipTo() + " table");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}

