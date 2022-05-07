package model;
public class Customer {
    private int customerID;
    private String firstName, lastName, address,email,phone,username,password;

    public Customer(int id, String firstName, String lastName, String address, String email, String phone) {
        this.customerID = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public Customer(int id, String firstName, String lastName, String address, String email, String phone, String username, String password) {
        this.customerID = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString(){
        return "Customer " + getCustomerID() + ":" 
                + getFirstName() + " "
                + getLastName() + " "
                + getEmail() + " "
                + getAddress() + " "
                + getPhone() + " ";
    }
}
