package Entities;

import Observers.Observer;

/**
 *
 * @author user
 */
public final class Customer extends Person {

    private String address;
    public static int DefaultId = 9999;
    private Observer aObserver;
    private Double balance;
    public Customer(int id, String name, String userName, String password, String address) {
        super(id, name, userName, password);
        setAdress(address);
    }
   
    
    public Customer() {
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     * @return 
     */
    public Customer setAdress(String address) {
        if (address.equalsIgnoreCase("")) {
            this.address = "unkwnon Address";
            return this;
        }
        this.address = address;
        return this;
    }
    
    public void attach(Observer aObserver){
        this.aObserver = aObserver;
    }

    public Double getBalance() {
        return balance;
    }

    public Customer setBalance(Double balance) {
        this.balance = balance;
        return this;
    }

    @Override
    public String toString() {
        super.toString();
        return "Customer{" + "address=" + address + getPassword()+ " "+getName()+" "+getUserName()+" "+ getPassword()+'}';
    }

}
