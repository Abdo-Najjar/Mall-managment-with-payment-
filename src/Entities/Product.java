package Entities;

import Observers.ProductObserver;

/**
 *
 * @author user
 */
public class Product {

    private String productName;
    private int pid;
    private double price;
    private int quantity;
    private int dId;
    private String productDescription;
    private ProductState state;
    private ProductObserver os;

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     * @return
     */
    public Product setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     * @return
     */
    public Product setPrice(double price) {
        this.price = price;
        return this;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     * @return
     */
    public Product setQuantity(int quantity) {
        if (quantity <= 0) {
            setState(new UnAvailableState());
            return this;
        }
        this.quantity = quantity;
        setState(new AvailableState());
        return this;
    }

    /**
     * @return the dId
     */
    public int getdId() {
        return dId;
    }

    /**
     * @param dId the dId to set
     * @return
     */
    public Product setdId(int dId) {
        this.dId = dId;
        return this;
    }

    /**
     * @return the productDescription
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * @param productDescription the productDescription to set
     * @return
     */
    public Product setProductDescription(String productDescription) {
        if (productDescription.equalsIgnoreCase("")) {
            this.productDescription = "unknown";
            return this;
        }
        this.productDescription = productDescription;
        return this;
    }

    /**
     * @return the state
     */
    public ProductState getState() {
        return state;
    }

    /**
     * @param state the state to set
     * @return
     */
    public Product setState(ProductState state) {
        this.state = state;
        return this;
    }

    public int getPid() {
        return pid;
    }

    public Product setPid(int pid) {
        this.pid = pid;
        return this;
    }

    public void attach(ProductObserver os) {
        this.os = os;
    }

    @Override
    public String toString() {
        return "Product{" + "productName=" + productName + ", pid=" + pid + ", price=" + price + ", quantity=" + quantity + ", dId=" + dId + ", productDescription=" + productDescription + ", state=" + state + '}';
    }

}
