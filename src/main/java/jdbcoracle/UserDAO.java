package jdbcoracle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    /**
     * Insert a new user
     * @param user
     * @return
     * @throws SQLException
     */
    public String saveUser(User user) throws SQLException {
        String response = null;
        try(Connection conn = DBConnection.getOracleDB();) {

            String sql = "INSERT INTO APPLICATION_TBL (application_id, description, application_name, owner) VALUES (application_id_seq.nextval, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);
           // statement.setInt(1, 'application_id_seq.nextval');
            statement.setString(1, user.getDescription());
            statement.setString(2, user.getApplication_name());
            statement.setString(3, user.getOwner());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                response = "A new user was inserted successfully!";
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return response;
    }

    public List<User> getAllUsers() throws SQLException {
        Connection conn = null;
        List<User> users = null;
        try {
            conn = DBConnection.getOracleDB();
            String sql = "select * from APPLICATION_TBL";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
           // statement.setInt(1, );
            users = new ArrayList<>();
            while (result.next()) {
                User user = new User();
                user.setApplication_id(result.getInt("application_id"));
                user.setApplication_name(result.getString("application_name"));
                user.setOwner(result.getString("owner"));
                user.setDescription(result.getString("description"));
                users.add(user);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            conn.close();
        }

        return users;
    }

    public List<User> selectContact(String APPLICATION_ID) throws SQLException{
        Connection conn = null;
        List<User> contacts = null;
        String response = null;

        try {
            conn = DBConnection.getOracleDB();
            String sql = "SELECT APPLICATION_ID, DESCRIPTION, APPLICATION_NAME, OWNER FROM APPLICATION_TBL WHERE APPLICATION_ID=?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(APPLICATION_ID));
            ResultSet rowsInserted = statement.executeQuery();

            response = "A existing user was getting successfully!";

            contacts = new ArrayList<>();
            while(rowsInserted.next())
            {
                User contact = new User();
                contact.setApplication_id(rowsInserted.getInt("application_id"));
                contact.setApplication_name(rowsInserted.getString("description"));
                contact.setOwner(rowsInserted.getString("application_name"));
                contact.setDescription(rowsInserted.getString("owner"));
                contacts.add(contact);
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            conn.close();
        }


        return contacts;
    }

    public String updateContact(User user) throws SQLException {

        Connection conn = null;
        String response = null;
        try {
            conn = DBConnection.getOracleDB();
            String sql = "UPDATE APPLICATION_TBL SET description=?, application_name=?, owner=? WHERE application_id=?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, user.getDescription());
            statement.setString(2, user.getApplication_name());
            statement.setString(3, user.getOwner());
            statement.setInt(4, user.getApplication_id());
            // statement.setInt(5, id);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                response = "A new user was updated successfully!";
            }


        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            conn.close();
        }
        return response;
    }

    public String deleteContact(int application_id) throws SQLException{
        Connection conn = null;
        String response = null;
        try {
            conn = DBConnection.getOracleDB();
            String sql = "DELETE FROM APPLICATION_TBL WHERE application_id=?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, application_id);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                response = "A new user was deleted successfully!";
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            conn.close();
        }

        return response;
    }

}
