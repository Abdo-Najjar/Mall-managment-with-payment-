package Observers;

import Entities.Product;
import MainGui.GuiMethods;

/**
 *
 * @author user
 */
public class ProductObserver extends Observer{

    public ProductObserver(Product aProduct) {
        this.aProduct = aProduct;
        aProduct.attach(this);
    }

    @Override
    public void update() {
        GuiMethods.viewProductList();
    }
    
}
