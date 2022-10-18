package jdbcoracle;


import java.io.IOException;

public class MainOracle {
    public static void main(String[] args) throws IOException {
       // Static method no need to create object method
        DBConnection.getOracleDB("C:\\Users\\Dell\\IdeaProjects\\OracleDB\\src\\resources\\db.properties");
        DBConnection.getConnectionFirstMethod("jdbc:oracle:thin:@localhost:1521:xe", "system", "nedumaran@86");
        DBConnection.getConnectionSecondMethod("jdbc:oracle:thin:@localhost:1521:xe?user=system&password=nedumaran@86");
    }
}
