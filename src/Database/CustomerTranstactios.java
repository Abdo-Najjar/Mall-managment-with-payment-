package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Entities.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class CustomerTranstactios {

    private final Connect connect;
    private final Connection con;
    private final String getProductsFromDepartments;
    private final String sendTransaction;

    protected CustomerTranstactios() {
        connect = Connect.getConnect();
        con = connect.getConnection();
        this.getProductsFromDepartments = "SELECT  `pname` FROM `products` where `did` = ? ";
            sendTransaction = "INSERT INTO `transactions` (`Quntity`, `Product Name`, `Customer Name`) VALUES (?,?,?)";
    }
    
    protected Integer sendTransaction(int aQuntity,String aProductName, String aCustomerName){
        try(PreparedStatement ps = con.prepareCall(sendTransaction)){
            ps.setInt(1, aQuntity);
            ps.setString(2, aProductName);
            ps.setString(3, aCustomerName);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return  null;
    }

    protected List<Product> getAllProductFromDepartment(int aDid) {
        List<Product> products;
        try (PreparedStatement ps = con.prepareCall(getProductsFromDepartments)) {
            ps.setInt(1, aDid);
            try (ResultSet rs = ps.executeQuery()) {
                products = new ArrayList<>();
                while (rs.next()) {
                    products.add(new Product().setProductName(rs.getString("pname")));
                }
            }

            return products;
        } catch (SQLException ex) {

        }
        return null;
    }

}
