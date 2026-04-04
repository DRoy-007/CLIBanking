
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthService {
    public static boolean register (String username, String password){
        try (Connection con = DBConnection.getConnection()) {
            String checkQuery = "SELECT * FROM users WHERE username = ?";
            PreparedStatement checkSt = con.prepareStatement(checkQuery);
            checkSt.setString(1, username);

            ResultSet rs = checkSt.executeQuery();

            if (rs.next()) {
                return false; // user exists
            }

            String insertQuery = "INSERT into users (username, password) values(?, ?)";
            PreparedStatement insertSt = con.prepareStatement(insertQuery);
            insertSt.setString(1, username);
            insertSt.setString(2, password);

            int rows = insertSt.executeUpdate();

            return rows > 0;

        } 
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int login(String username, String password) {
        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT user_id, password FROM users WHERE username = ?";
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, username);

            ResultSet rs = st.executeQuery();

            if(!rs.next()) return -1;

            String dbPasssword = rs.getString("password");
            if (!dbPasssword.equals(password)) return -1;

            return rs.getInt("user_id");
        }

        catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }
}
