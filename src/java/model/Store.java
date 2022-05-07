package model;

public class Store {
    private int storeID;
    private String name,address;

    public Store(int storeID, String name, String address) {
        this.storeID = storeID;
        this.name = name;
        this.address = address;
    }

    public int getStoreID() {
        return storeID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
