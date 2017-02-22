package requests;

import java.sql.*;

public class SelectFromDb {
    public static StringBuilder selectFromItem(Connection con) {
        PreparedStatement preparedStatement;
        String itemTable = "Item";
        String sqlRequest = "SELECT * FROM " + itemTable;
        ResultSet rs = null;

        StringBuilder itemsInfo = new StringBuilder();
        String id;
        String itemTitle;
        String itemNote;
        String itemQuantity;
        String itemPrice;

        try {
            preparedStatement = con.prepareStatement(sqlRequest);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                id = String.valueOf(rs.getInt("Id"));
                itemTitle = rs.getString("ItemTitle");
                itemNote = rs.getString("ItemNote");
                itemQuantity = String.valueOf(rs.getInt("ItemQuantity"));
                itemPrice = String.valueOf(rs.getDouble("ItemPrice"));
                itemsInfo.append("\n" + "Item ID: \t \t" + id + "\n"
                        + "ItemTitle: \t \t" + itemTitle + "\n"
                        + "ItemNote: \t \t" + itemNote + "\n"
                        + "ItemQuantity: \t \t" + itemQuantity + "\n"
                        + "ItemPrice: \t \t" + itemPrice + "\n");
            }

            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return itemsInfo;
    }

    public static StringBuilder selectFromOrderPerson(Connection con) {
        PreparedStatement preparedStatement;
        String orderPersonTable = "OrderPerson";
        String sqlRequest = "SELECT * FROM " + orderPersonTable;
        ResultSet rs = null;

        StringBuilder personsInfo = new StringBuilder();
        String id;
        String personName;

        try {
            preparedStatement = con.prepareStatement(sqlRequest);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                id = String.valueOf(rs.getInt("Id"));
                personName = rs.getString("PersonName");
                personsInfo.append("\n" + "Item ID: \t \t" + id + "\n"
                        + "PresonName: \t \t" + personName + "\n");
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personsInfo;
    }

    public static StringBuilder selectFromShipTo(Connection con) {
        PreparedStatement preparedStatement;
        String shipToTable = "ShipTo";
        String sqlRequest = "SELECT * FROM " + shipToTable;
        ResultSet rs = null;

        StringBuilder shipsInfo = new StringBuilder();
        String id;
        String shipToName;
        String shipToAddress;
        String shipToCity;
        String shipToCountry;

        try {
            preparedStatement = con.prepareStatement(sqlRequest);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                id = String.valueOf(rs.getInt("Id"));
                shipToName = rs.getString("ShipToName");
                shipToAddress = rs.getString("ShipToAddress");
                shipToCity = rs.getString("ShipToCity");
                shipToCountry = rs.getString("ShipToCountry");
                shipsInfo.append("\n" + "Item ID: \t \t" + id + "\n"
                        + "ShipToName: \t \t" + shipToName + "\n"
                        + "ShipToAddress: \t" + shipToAddress + "\n"
                        + "ShipToCity: \t \t" + shipToCity + "\n"
                        + "ShipToCountry: \t \t" + shipToCountry + "\n");
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return shipsInfo;
    }

}