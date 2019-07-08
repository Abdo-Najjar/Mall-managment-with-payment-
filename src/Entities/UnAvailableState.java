package Entities;

/**
 *
 * @author user
 */
public class UnAvailableState implements ProductState{

    @Override
    public void addState(Product aProduct) {
        aProduct.setState(this);
        
    }

    @Override
    public String isAvailable() {
        return "Not Available";
    }
    
}
