package jdbcoracle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    public static Connection getOracleDB() throws FileNotFoundException, IOException{
        Connection connection = null;
        Properties prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\Dell\\IdeaProjects\\OracleDB\\src\\resources\\db.properties");
            prop.load(fis);

            connection = DriverManager.getConnection(prop.getProperty("DB_URL"),
                    prop.getProperty("DB_USERNAME"),
                    prop.getProperty("DB_PASSWORD"));
            if (connection != null) {
                System.out.println("Connected to the oracle database karthik");
            }
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
        return connection;
    }

    public static Connection getConnectionFirstMethod(String url, String username, String password) throws IOException {
        Connection conn = null;
        try {
            String host = url;
            String login = username;
            String encrypt = password;
            conn = DriverManager.getConnection(url, username, password);
            if (conn != null) {
                System.out.println("Connect to the oracle database in first method");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            e.printStackTrace();
        }
        return conn;
    }

    public static Connection getConnectionSecondMethod(String url) {
        Connection conn = null;
        try {
            String host = url;
            conn=DriverManager.getConnection(url);
            if(conn!=null){
                System.out.println("Connect to the oracle database in second method");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return conn;
    }
}
