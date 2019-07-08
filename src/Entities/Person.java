package Entities;

import javax.swing.JOptionPane;

public class Person {

    private int id;
    private String name;
    private String userName;
    private String password;

    public Person(int id, String name, String userName, String password) {
        setId(id);
        setName(name);
        setUserName(userName);
        setPassword(password);
    }

    public Person() {
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     * @return 
     */
    public final Person setName(String name) {
        if (name.equals("")) {
            this.name = "unknown";
            return this;
        }
        this.name = name;
        return this;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     * @return 
     */
    public final Person setUserName(String userName) {
        if (userName.equals("")) {
            this.userName = "unknown";
            return this;
        }
        this.userName = userName;
        return this;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     * @return 
     */
    public final Person setPassword(String password) {
        if (password.equals("")) {
            this.password = "password";
            return this;
        }
        this.password = password;
        return this;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     * @return 
     */
    public final Person setId(int id) {
        if (id <= 0) {
            JOptionPane.showMessageDialog(null, "Invalid ID");
            return this;
        }
        this.id = id;
        return this;
    }

}
