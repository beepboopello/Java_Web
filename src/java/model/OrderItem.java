package model;

public class OrderItem {
    private int itemID,orderID,productID,quantity;
    private long discount,price;

    public OrderItem(int itemID, int orderID, int productID, int quantity, long discount, long price) {
        this.itemID = itemID;
        this.orderID = orderID;
        this.productID = productID;
        this.quantity = quantity;
        this.discount = discount;
        this.price = price;
    }

    public int getItemID() {
        return itemID;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getProductID() {
        return productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public long getDiscount() {
        return discount;
    }

    public long getPrice() {
        return price;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDiscount(long discount) {
        this.discount = discount;
    }

    public void setPrice(long price) {
        this.price = price;
    }
    
    
}
