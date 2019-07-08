package AddtionGui;

import javax.swing.JFrame;

/**
 *
 * @author user
 */
public class AddGuiFactory {

    public final static String addNewProduct = "Product";
    public final static String addNewCustomer = "Customer";
    public final static String addNewDepartment = "Department";

    public static JFrame getAddGui(String name) {
        if (name.equalsIgnoreCase(AddGuiFactory.addNewCustomer)) {
            return new AddNewCustomer();
        } else if (name.equalsIgnoreCase(AddGuiFactory.addNewProduct)) {
            return new AddnewProduct();
        } else if (name.equalsIgnoreCase(AddGuiFactory.addNewDepartment)) {
            return new AddNewDepartment();
        } else {
            return new AddNewDepartment();
        }
    }
}
