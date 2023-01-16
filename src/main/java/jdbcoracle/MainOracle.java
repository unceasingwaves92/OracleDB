package jdbcoracle;


import java.io.IOException;
import java.sql.SQLException;

public class MainOracle {
    public static void main(String[] args) throws  IOException {
       // Static method no need to create object method
   //     DBConnection.getOracleDB("C:\\Users\\Dell\\IdeaProjects\\OracleDB\\src\\resources\\db.properties");
      //  DBConnection.getConnectionFirstMethod("jdbc:oracle:thin:@localhost:1521:xe", "system", "nedumaran@86");
       // DBConnection.getConnectionSecondMethod("jdbc:oracle:thin:@localhost:1521:xe?user=system&password=nedumaran@86");
        UserDAO userDAO = new UserDAO();
        User user = new User();
      //  user.setApplication_id(1);
        user.setDescription("welcome oracle database");
        user.setApplication_name("JavaOracle");
        user.setOwner("regu");

        try {
            String response = userDAO.saveUser(user);
            System.out.println(response);

            //user.setDescription("welcome java");
            //user.setApplication_name("database");
            //user.setOwner("manika");
            //user.setApplication_id(3);
          //  System.out.println(userDAO.updateContact(user));
          //  System.out.println(userDAO.getAllUsers());
            System.out.println(userDAO.selectContact("3"));
            userDAO.deleteContact(3);
        } catch (SQLException  e) {
            e.printStackTrace();
        }    }
}



