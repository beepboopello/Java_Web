package model;
public class Seller {
    private int sellerID;
    private String firstName, lastName, address,email,phone,username,password;
    private int storeid;

    public Seller(int id, String firstName, String lastName, String address, String email, String phone, int storeid) {
        this.sellerID = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.storeid = storeid;
    }

    public Seller(int id, String firstName, String lastName, String address, String email, String phone, String username, String password, int storeid) {
        this.sellerID = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.storeid = storeid;
    }

    public int getSellerID() {
        return sellerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
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

    public int getStoreid() {
        return storeid;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void setStoreid(int storeid) {
        this.storeid = storeid;
    }
    
    @Override
    public String toString(){
        return "Seller " + getSellerID() + ": "
                +getFirstName() + " "
                +getLastName() + " "
                +getAddress() + " "
                +getEmail() + " "
                +getPhone() + " "
                +getStoreid();
    }
}
