package model;
public class Orders {
    private int orderID,customerID,storeID,sellerID;
    private String status, order_date;

    public Orders(int orderID, int customerID, int storeID, int sellerID, String order_date, String status) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.storeID = storeID;
        this.sellerID = sellerID;
        this.status = status;
        this.order_date = order_date;
    }
    public Orders(){
    }

    public int getOrderID() {
        return orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getStoreID() {
        return storeID;
    }

    public int getSellerID() {
        return sellerID;
    }

    public String getStatus() {
        return status;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }
    @Override
    public String toString(){
        return "Order " + getOrderID() + ": "
                + getCustomerID() + " "
                + getOrder_date() + " "
                + getStoreID()+ " "
                + getSellerID()+ " "
                + getStatus();
    }
}
