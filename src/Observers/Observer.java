package Observers;

import Entities.Customer;
import Entities.Department;
import Entities.Product;

/**
 *
 * @author user
 */
public abstract class Observer {
    protected Customer aCustomer;
    protected Department aDepartment;
    protected Product aProduct;
    public abstract void update();
}
