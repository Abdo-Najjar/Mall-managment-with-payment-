package Observers;

import Entities.Customer;
import MainGui.GuiMethods;

/**
 *
 * @author user
 */
public class CustomerObserver extends Observer{

    public CustomerObserver(Customer aCustomer) {
        this.aCustomer = aCustomer;
        aCustomer.attach(this);
    }

    @Override
    public void update() {
        GuiMethods.viewCustomerList();
    }
        
   
    
}
