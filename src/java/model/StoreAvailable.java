package model;

public class StoreAvailable {
    private int storeID,productID,quantity;

    public StoreAvailable(int storeID, int productID, int quantity) {
        this.storeID = storeID;
        this.productID = productID;
        this.quantity = quantity;
    }

    public int getStoreID() {
        return storeID;
    }

    public int getProductID() {
        return productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public String toString(){
        return "Number of Product_id " + getProductID() + " in " + getStoreID() + ": " + getQuantity();
    }
}
