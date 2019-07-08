package Entities;

import Observers.DepartmentObserver;
import Observers.Observer;

/**
 *
 * @author user
 */
public final class Department {
    private int did;
    private String name;
    private String Description;
    private Observer aObserver;

    public Department(int did, String name, String Description) {
        setDid(did);
        setName(name);
        setDescription(Description);
    }

    public Department(String name, String Description) {
        setName(name);
        setDescription(Description);

    }

    public Department() {
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    public int getDid() {
        return did;
    }

    public Department setDid(int did) {
        this.did = did;
        return this;
    }

    /**
     * @param name the name to set
     * @return
     */
    public Department setName(String name) {
        if (name.equals("")) {
            this.name = "unknown";
            return this;
        }
        this.name = name;
        return this;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     * @return
     */
    public Department setDescription(String Description) {
        if (Description.equals("")) {
            this.Description = "unknown";
            return this;
        }
        this.Description = Description;
        return this;
    }

    public void attach(Observer aObserver) {
        this.aObserver = aObserver;
    }

    public void notifyObservers() {
        this.aObserver.update();
    }

    @Override
    public String toString() {
        return "Department{" + "did=" + did + ", name=" + name + ", Description=" + Description + '}';
    }

    
}
