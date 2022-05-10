package model;
public class Product {
    private int productID,quantity,availability;
    private String name,category,brand,color,size,description,image,discount;
    private float price;
    public Product() {
    }
    public Product(int productID, int quantity, int availability, String name, String category, String brand, String color, String size, String description, String image, String discount, float price) {
        this.productID = productID;
        this.quantity = quantity;
        this.availability = availability;
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.color = color;
        this.size = size;
        this.description = description;
        this.image = image;
        this.discount = discount;
        this.price = price;
    }
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return
                "Product " + getProductID()+ ": "
                + getName() + " "
                + getCategory() + " "
                + getBrand()+ " "
                + getColor()+ " "
                + getSize() + " "
                + getPrice() + " "
                + getDescription() + " "
                + getImage() + " "
                +Integer.toString(getQuantity()) + " "
                +Integer.toString(getAvailability())
                + getDiscount()
                ;
    }
}
