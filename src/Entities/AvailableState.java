package Entities;

/**
 *
 * @author user
 */
public class AvailableState implements ProductState{
    
    @Override
    public void addState(Product aProduct) {
        aProduct.setState(this);
    }

    @Override
    public String isAvailable() {
        return "Available";
    }
    
}
