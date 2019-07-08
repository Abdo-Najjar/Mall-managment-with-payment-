package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class Authentication {

    private final Connect connect;
    private final String authenManagerQuery;
    private final String authenCustomerQuery;
    private final Connection con;

    public Authentication() {
        connect = Connect.getConnect();
        con = connect.getConnection();
        authenCustomerQuery = "select password from customers where uname = ?";
        authenManagerQuery = "select password from managers where uname = ?";

    }

    protected boolean authenManager(String aName, String aPassword) {
        try (PreparedStatement ps = con.prepareCall(authenManagerQuery)) {
            ps.setString(1, aName);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String password = rs.getString(1);
            rs.close();
            if (aPassword.equals(password)) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }

    protected boolean authenCustomer(String aName, String aPassword) {
        try (PreparedStatement ps = con.prepareCall(authenCustomerQuery)) {
            ps.setString(1, aName);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String password = rs.getString(1);
            rs.close();
            if (aPassword.equals(password)) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }

}
