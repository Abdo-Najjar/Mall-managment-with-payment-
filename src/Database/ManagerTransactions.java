package Database;

import Entities.Customer;
import Entities.Department;
import Entities.Product;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author user
 */
public class ManagerTransactions {

    private final Connect connect;
    private final Connection con;
    private final String addDepartment;
    private final String addCustomer;
    private final String getAllDeparments;
    private final String getDepartment;
    private final String deleteDepartment;
    private final String updateDepartment;
    private final String getAllCustomers;
    private final String getCustomer;
    private final String getCustomerByid;
    private final String deleteCustomer;
    private final String updateCustomer;
    private final String getAllProducts;
    private final String addProduct;
    private final String getAllProduct;
    private final String deleteProduct;
    private final String getProduct;
    private final String getDepartmentById;
    private final String updateProduct;
    private final String getAllTransaactions;
    private final String deleteAllTransactions;

    public ManagerTransactions() {
        connect = Connect.getConnect();
        con = connect.getConnection();
        addDepartment = "insert into departments (dname , description) values (?,?)";
        addCustomer = "insert into customers ( name , uname , password , address , balance) values (?,?,?,?,?)";
        getAllDeparments = "select * from departments";
        getDepartment = "select * from departments where dname = ?";
        deleteDepartment = "delete from departments where did = ?";
        updateDepartment = "update departments set dname = ? , description = ?  where did = ?";
        getAllCustomers = "select * from customers";
        getCustomer = "select * from customers where  uname = ?";
        deleteCustomer = "delete from customers where id = ?";
        updateCustomer = "update customers set name = ? , uname = ? , password = ? , address = ? , balance = ? where id = ?";
        getAllProducts = "select * from products";
        addProduct = "INSERT INTO `products`(`pname`, `price`, `quantity`, `did`, `description`) VALUES (?,?,?,?,?)";
        getAllProduct = "select * from products";
        deleteProduct = "delete from products where pname = ?";
        getProduct = "select * from products where pname = ?";
        getDepartmentById = "select * from departments where did = ?";
        updateProduct = "UPDATE `products` SET `pname`= ?,`price`= ? ,`quantity`= ? ,`did`= ?,`description`= ? WHERE pid = ?";
        getCustomerByid = "select * from customers where  id = ?";
        getAllTransaactions = "select * from transactions";
        deleteAllTransactions = "delete from transactions";
    }

    protected Integer deleteAllTransactions() {
        try {
            PreparedStatement st = con.prepareCall(deleteAllTransactions);
            return st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    protected void getAllTransactions(JTable table) {

        try {
            PreparedStatement st = con.prepareCall(getAllTransaactions);
            st.executeQuery();
            ResultSet rs = st.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    protected Customer getCustomer(int aCid) {
        try (PreparedStatement ps = con.prepareCall(getCustomerByid)) {
            ps.setInt(1, aCid);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return (Customer) new Customer().
                        setAdress(rs.getString("address")).
                        setBalance(rs.getDouble("balance")).
                        setId(rs.getInt("id")).
                        setUserName(rs.getString("uname")).
                        setName(rs.getString("name")).
                        setPassword(rs.getString("password"));
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    protected Integer updateProduct(String aPName, double aPPrice, int aPQuantity, int PDid, String aPDescription, int aPid) {
        try (PreparedStatement ps = con.prepareCall(updateProduct)) {
            ps.setString(1, aPName);
            ps.setDouble(2, aPPrice);
            ps.setInt(3, aPQuantity);
            ps.setInt(4, PDid);
            ps.setString(5, aPDescription);
            ps.setInt(6, aPid);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    protected Department getDepartment(int aDid) {
        try (PreparedStatement ps = con.prepareCall(getDepartmentById)) {
            ps.setInt(1, aDid);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String description = rs.getString("description");
            String aDName = rs.getString("dname");
            rs.close();
            return new Department(aDid, aDName, description);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    protected Product getProduct(String aPName) {
        try (PreparedStatement ps = con.prepareCall(getProduct)) {
            ps.setString(1, aPName);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return new Product().
                        setQuantity(rs.getInt("quantity")).
                        setPrice(rs.getDouble("price")).
                        setProductDescription(rs.getString("description")).
                        setProductName(rs.getString("pname")).
                        setdId(rs.getInt("did")).
                        setPid(rs.getInt("pid"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    protected Integer addProduct(Product aProduct) {
        try (PreparedStatement ps = con.prepareCall(addProduct)) {
            ps.setString(1, aProduct.getProductName());
            ps.setDouble(2, aProduct.getPrice());
            ps.setInt(3, aProduct.getQuantity());
            ps.setInt(4, aProduct.getdId());
            ps.setString(5, aProduct.getProductDescription());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    protected Integer addDepartment(Department aDepartment) {
        try (PreparedStatement ps = con.prepareCall(addDepartment)) {
            ps.setString(1, aDepartment.getName());
            ps.setString(2, aDepartment.getDescription());
            int result = ps.executeUpdate();
            return result;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    protected Department getDepartment(String aDName) {
        try (PreparedStatement ps = con.prepareCall(getDepartment)) {
            ps.setString(1, aDName);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String description = rs.getString("description");
            int did = rs.getInt("did");
            rs.close();
            return new Department(did, aDName, description);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public Customer getCustomer(String aCUName) {
        try (PreparedStatement ps = con.prepareCall(getCustomer)) {
            ps.setString(1, aCUName);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return (Customer) new Customer().
                    setAdress(rs.getString("address")).
                    setBalance(rs.getDouble("balance")).
                    setId(rs.getInt("id")).
                    setUserName(rs.getString("uname")).
                    setName(rs.getString("name")).
                    setPassword(rs.getString("password"));
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    protected Integer deleteCustomer(int aCid) {
        try (PreparedStatement ps = con.prepareCall(deleteCustomer)) {
            ps.setInt(1, aCid);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    protected Integer deleteProduct(String aPName) {
        try (PreparedStatement ps = con.prepareCall(deleteProduct)) {
            ps.setString(1, aPName);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    protected Integer addCustomer(Customer aCustomer) {
        try (PreparedStatement ps = con.prepareCall(addCustomer)) {
            ps.setString(1, aCustomer.getName());
            ps.setString(2, aCustomer.getUserName());
            ps.setString(3, aCustomer.getPassword());
            ps.setString(4, aCustomer.getAddress());
            ps.setDouble(5, aCustomer.getBalance());
            int result = ps.executeUpdate();
            return result;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    protected List<Product> getAllProducts() {
        List<Product> products;
        try (PreparedStatement ps = con.prepareCall(getAllProducts)) {
            try (ResultSet rs = ps.executeQuery()) {
                products = new ArrayList<>();
                while (rs.next()) {
                    products.add(new Product().
                            setPrice(rs.getDouble("price")).
                            setProductDescription(rs.getString("description")).
                            setProductName(rs.getString("pname")).
                            setQuantity(rs.getInt("quantity")).
                            setdId(rs.getInt("did")));
                }
                return products;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    protected List<Department> getAllDepartment() {
        List<Department> departments = new ArrayList<>();
        try (Statement s = con.createStatement()) {
            ResultSet rs = s.executeQuery(getAllDeparments);
            while (rs.next()) {
                departments.add(new Department().
                        setName(rs.getString("dname")).
                        setDescription(rs.getString("description")).setDid(rs.getInt("did")));
            }
            rs.close();
            return departments;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    protected List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try (Statement s = con.createStatement()) {
            ResultSet rs = s.executeQuery(getAllCustomers);
            while (rs.next()) {
                customers.add((Customer) new Customer().
                        setAdress(rs.getString("address")).
                        setId(rs.getInt("id")).
                        setName(rs.getString("name")).
                        setUserName(rs.getString("uname")).
                        setPassword("password"));
            }
            rs.close();
            return customers;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    protected Integer deleteDepartment(int ADid) {
        try (PreparedStatement ps = con.prepareCall(deleteDepartment)) {
            ps.setInt(1, ADid);
            int rs = ps.executeUpdate();
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    protected Integer updateDepartment(String aDName, String aDDescription, int aDid) {
        try (PreparedStatement ps = con.prepareCall(updateDepartment)) {
            ps.setString(1, aDName);
            ps.setString(2, aDDescription);
            ps.setInt(3, aDid);
            int restult = ps.executeUpdate();
            return restult;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    protected Integer updateCustomer(Customer aCustomer) {
        try (PreparedStatement ps = con.prepareCall(updateCustomer)) {
            ps.setString(1, aCustomer.getName());
            ps.setString(2, aCustomer.getUserName());
            ps.setString(3, aCustomer.getPassword());
            ps.setString(4, aCustomer.getAddress());
            ps.setDouble(5, aCustomer.getBalance());
            ps.setInt(6, aCustomer.getId());
            int effected = ps.executeUpdate();
            return effected;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
}
