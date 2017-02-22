package requests;

import tables.ItemTable;
import tables.OrderPersonTable;
import tables.ShipToTable;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class InsertRequest {
    private Connection con;

    public InsertRequest(Connection connection) {
        this.con = connection;
    }

    public void insertToItemTable(XmlValues xmlValues) {
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
                + "'" + xmlValues.getItemTitleValue() + "', "
                + "'" + xmlValues.getItemNoteValue() + "', "
                + "'" + xmlValues.getItemQuantityValue() + "', "
                + xmlValues.getItemPriceValue() + ")";

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

    public void insertToOrderPersonTable(XmlValues xmlValues) {
        Statement statement = null;
        OrderPersonTable orderPersonTable = new OrderPersonTable();
        String valueToItemTableRequest = "INSERT INTO "
                + orderPersonTable.getTableOrderPerson() + " ("
                + orderPersonTable.getOrderPersonNameValue() + ") "
                + "VALUES "
                + "("
                + "'" + xmlValues.getOrderPersonValue() + "'"
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

    public void insertToShipToTable(XmlValues xmlValues) {
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
                + "'" + xmlValues.getShipToNameValue() + "', "
                + "'" + xmlValues.getShipToAddressValue() + "', "
                + "'" + xmlValues.getShipToCityValue() + "', "
                + "'" + xmlValues.getShipToCountryValue() + "'"
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

