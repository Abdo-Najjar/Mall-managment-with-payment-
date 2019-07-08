package MainGui;

import Database.DBMaker;
import Entities.Department;
import Entities.Product;
import Observers.DepartmentObserver;
import java.awt.Color;
import java.awt.Container;
import static java.awt.Frame.NORMAL;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.ImageObserver;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author user
 */
public class GuiMethods {

    public static void addWindowListener(JFrame frame) {
        frame.setDefaultCloseOperation(NORMAL);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                String ObjButtons[] = {"Yes", "No"};
                int PromptResult = JOptionPane.showOptionDialog(null,
                        "Are you sure you want to exit?", "Exit",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
                        ObjButtons, ObjButtons[1]);
                if (PromptResult == 0) {
                    System.exit(0);
                }
            }
        });
    }

    public static void frameSets(Container c, Color color) {
        c.setBackground(color);
    }

    public static boolean isEmptyFields(JFrame f, JTextField... fields) {
        for (JTextField tf : fields) {
            if (tf.getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(f, "Empty Fields", "Something is messing", JOptionPane.ERROR_MESSAGE);
                return true;
            }
        }
        return false;
    }

    public static void emptyFields(JTextField... fields) {
        for (JTextField tf : fields) {
            tf.setText("");
        }
    }

    public static void addWindowListenerSub(JFrame frame) {
        frame.setDefaultCloseOperation(NORMAL);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                frame.dispose();
            }
        });
    }

    public static void viewDepartmentList() {
        Manager_Window.DepaertmentsComboBoxModel.removeAllElements();
        Manager_Window.DepartmentModel.clear();
        DBMaker.getDBMaker().getAllDepartmentMaker().forEach((t) -> {
            Manager_Window.DepartmentModel.addElement(t.getName());
            Manager_Window.DepaertmentsComboBoxModel.addElement(t.getName());

        });
    }

    public static void viewCustomerList() {
        Manager_Window.CustomerModel.clear();
        DBMaker.getDBMaker().getAllCustomersMaker().forEach((t) -> {
            Manager_Window.CustomerModel.addElement(t.getUserName());
        });
    }

    public static void viewProductList() {
        Manager_Window.ProductModel.clear();
        DBMaker.getDBMaker().getAllProductsMaker().forEach((Product t) -> {
            Manager_Window.ProductModel.addElement(t.getProductName());
        });

    }

    public static void viewDepartmentsForCustomer() {
        DBMaker.getDBMaker().getAllDepartmentMaker().forEach((t) -> {
            Customer_Window.departmentsModel.addElement(t.getName());
        });
    }

    public static void Logout(JFrame f) {
        String ObjButtons[] = {"Yes", "No"};
        int PromptResult = JOptionPane.showOptionDialog(null,
                "Are you sure you want to Logout", "logout",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
                ObjButtons, ObjButtons[1]);
        if (PromptResult == 0) {
            f.dispose();
            new Login().setVisible(true);
        }

    }

    public void setIcon(JButton button , String url , int width , int height) {
        ImageIcon ic = new ImageIcon(url);
        Image image = ic.getImage(); 
        Image newimg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH); 
        ic = new ImageIcon(newimg);
        button.setIcon(ic);
    }
}
