import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Driver {

    private String userName = "in2033t21_a";
    private String password = "se9dEYA5yQc";
    private String dbms = "mysql";
    private String serverName = "smcse-stuproj00.city.ac.uk";
    private String portNumber = "3306";
    private String dbName = "in2033t21";

    public static void main(String[] args) throws ClassNotFoundException {
        Driver driver = new Driver();
        driver.getConnection();
        System.out.println(driver.getConnection());
    }

    public Connection getConnection() throws ClassNotFoundException {
        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.userName);
        connectionProps.put("password", this.password);

        String connectionString = "jdbc:" + this.dbms + "://" +
                this.serverName +
                ":" + this.portNumber + "/" +
                this.dbName;

        try {
            conn = DriverManager.getConnection(connectionString, connectionProps);
            System.out.println("Connected to database");
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("VendorError: " + e.getErrorCode());
        }
        return conn;
    }
}