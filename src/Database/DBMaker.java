package Database;

import Entities.Customer;
import Entities.Department;
import Entities.Product;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author user
 */
public class DBMaker {

    private static DBMaker dBMaker;
    private final Authentication authentication;
    private final ManagerTransactions managerTransactions;
    private final CustomerTranstactios customerTranstactios;

    private DBMaker() {
        authentication = new Authentication();
        managerTransactions = new ManagerTransactions();
        customerTranstactios = new CustomerTranstactios();
    }

    public static DBMaker getDBMaker() {
        if (dBMaker == null) {
            dBMaker = new DBMaker();
        }
        return dBMaker;
    }

    public boolean authenManagerMaker(String aName, String aPassword) {
        return authentication.authenManager(aName, aPassword);
    }

    public boolean authenCustomerMaker(String aName, String aPassword) {
        return authentication.authenCustomer(aName, aPassword);
    }

    public Integer addDepartmentMaker(Department aDepartment) {
        return managerTransactions.addDepartment(aDepartment);
    }

    public Integer addCustomerMaker(Customer aCustomer) {
        return managerTransactions.addCustomer(aCustomer);
    }

    public List<Department> getAllDepartmentMaker() {
        return managerTransactions.getAllDepartment();
    }

    public Department getDepartmentMaker(String aDName) {
        return managerTransactions.getDepartment(aDName);
    }

    public Integer deleteDepartmentMaker(int aDid) {
        return managerTransactions.deleteDepartment(aDid);
    }

    public Integer updateDepartmentMaker(String aDName, String aDDescription, int aDid) {
        return managerTransactions.updateDepartment(aDName, aDDescription, aDid);
    }

    public List<Customer> getAllCustomersMaker() {
        return managerTransactions.getAllCustomers();
    }

    public Customer getCustomerMaker(String aCUName) {
        return managerTransactions.getCustomer(aCUName);
    }

    public Integer deleteCustomerMaker(int aCid) {
        return managerTransactions.deleteCustomer(aCid);
    }

    public Integer updateCustomerMaker(Customer aCustomer) {
        return managerTransactions.updateCustomer(aCustomer);
    }

    public List<Product> getAllProductsMaker() {
        return managerTransactions.getAllProducts();
    }

    public Integer addProductMaker(Product aProduct) {
        return managerTransactions.addProduct(aProduct);
    }

    public Integer deleteProductMaker(String aPName) {
        return managerTransactions.deleteProduct(aPName);
    }

    public Product getProductMaker(String aPName) {
        return managerTransactions.getProduct(aPName);
    }

    public Department getDepartmentMaker(int aDid) {
        return managerTransactions.getDepartment(aDid);
    }

    public Integer updateProductMaker(String aPName, double aPPrice, int aPQuantity, int PDid, String aPDescription, int aPid) {
        return managerTransactions.updateProduct(aPName, aPPrice, aPQuantity, PDid, aPDescription, aPid);
    }

    public Customer getCustomerMaker(int aCid) {
        return managerTransactions.getCustomer(aCid);
    }

    public List<Product> getAllProductFromDepartmentMaker(int aDid) {
        return customerTranstactios.getAllProductFromDepartment(aDid);
    }

    public Integer sendTransactionMaker(int aQuntity, String aProductName, String aCustomerName) {
        return customerTranstactios.sendTransaction(aQuntity, aProductName, aCustomerName);
    }

    public void getAllTransactionsMaker(JTable table) {
        managerTransactions.getAllTransactions(table);
    }

    public Integer deleteAllTransactionsMaker() {
        return managerTransactions.deleteAllTransactions();

    }
}
