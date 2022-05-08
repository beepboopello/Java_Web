package model;
public class Product {
    private int productID;
    private String name,category,brand,color,size,description,image;
    private float price;

    public Product() {
    }

    
    public Product(int id, String name, String category, String brand, String color, String size, float price, String description, String image) {
        this.productID = id;
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.color = color;
        this.size = size;
        this.price = price;
        this.description = description;
        this.image = image;        
    }

    public int getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public float getPrice() {
        return price;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
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
                ;
    }
}
