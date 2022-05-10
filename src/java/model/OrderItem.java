package model;

public class OrderItem {
    private int itemID,orderID,productID,quantity;
    private String discount,name,img;
    private float price;

    public OrderItem(int itemID, int orderID, int productID, int quantity, String discount, float price) {
        this.itemID = itemID;
        this.orderID = orderID;
        this.productID = productID;
        this.quantity = quantity;
        this.discount = discount;
        this.price = price;
    }
    public OrderItem(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public String getDiscount() {
        return discount;
    }

    public float getPrice() {
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

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    @Override   
    public String toString(){
        return Integer.toString(itemID) + " " + Integer.toString(orderID) + " " + Integer.toString(productID) + " " + Integer.toString(quantity) + " " + discount + " " + Float.parseFloat(discount);
    }
    
    
}
