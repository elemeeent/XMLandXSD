import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnector {
    private Connection newConn;
    private static DataBaseConnector instance;

    public static synchronized DataBaseConnector getInstance() {
        if (instance == null) {
            instance = new DataBaseConnector();
        }
        return instance;
    }

    private DataBaseConnector() {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String driverURL = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)}; DBQ=" + "D:\\JAVA\\XMLandXSD\\DB\\xmlDB.mdb";
            this.newConn = DriverManager.getConnection(driverURL);
            String dbFolder = "D:\\JAVA\\XMLandXSD\\DB\\xmlDB.mdb";
            System.out.println("Db from current folder " + dbFolder + " connected succesfully");

        } catch (SQLException e) {
            System.out.println("SQL Exception catched...");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFound Exception catched...");
            e.printStackTrace();
        }
    }

    public Connection getNewConn() {
        return newConn;
    }
}