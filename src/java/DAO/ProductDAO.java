package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Product;

public class ProductDAO extends DAO{
    public void addProduct(Product p){
        String sql = "INSERT INTO [dbo].[product]" +
"           ([product_id]" +
"           ,[product_name]" +
"           ,[category]" +
"           ,[brand]" +
"           ,[color]" +
"           ,[size]" +
"           ,[price]" +
"           ,[product_description]" +
"           ,[product_image]" +
"           ,[quantity]" +
"           ,[availability]" +
"           ,[discount])" +
"     VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getProductID());
            ps.setString(2, p.getName());
            ps.setString(3, p.getCategory());
            ps.setString(4, p.getBrand());
            ps.setString(5, p.getColor());
            ps.setString(6, p.getSize());
            ps.setFloat(7, p.getPrice());
            ps.setString(8, p.getDescription());
            ps.setString(9, p.getImage());
            ps.setInt(10, p.getQuantity());
            ps.setInt(11, p.getAvailability());
            ps.setString(12, p.getDiscount());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateProduct(Product p){
        String sql = "UPDATE [dbo].[product]" +
"   SET [product_name] = ?" +
"      ,[category] = ?" +
"      ,[brand] = ?" +
"      ,[color] = ?" +
"      ,[size] = ?" +
"      ,[price] = ?" +
"      ,[product_description] = ?" +
"      ,[product_image] = ?" +
"      ,[quantity] = ?" +
"      ,[availability] = ?" +
"      ,[discount] = ?" +
" WHERE [product_id] = ?";
         try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(12, p.getProductID());
            ps.setString(1, p.getName());
            ps.setString(2, p.getCategory());
            ps.setString(3, p.getBrand());
            ps.setString(4, p.getColor());
            ps.setString(5, p.getSize());
            ps.setFloat(6, p.getPrice());
            ps.setString(7, p.getDescription());
            ps.setString(8, p.getImage());
            ps.setInt(9, p.getQuantity());
            ps.setInt(10, p.getAvailability());
            ps.setString(11, p.getDiscount());
            ps.executeUpdate();
        } catch (SQLException e) {
            
        }
    }
    
    public void deleteProduct(int id){
        String sql = "DELETE FROM product WHERE product_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Product> getPlist(){
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM product where availability=1";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int pid = rs.getInt("product_id");
                String pname = rs.getString("product_name");
                String pcategory = rs.getString("category");
                String pbrand = rs.getString("brand");
                String pcolor = rs.getString("color");
                String psize = rs.getString("size");
                float  pprice = rs.getFloat("price");
                String pdescription = rs.getString("product_description");
                String pimage = rs.getString("product_image");
                String pdiscount = rs.getString("discount");
                int pquantity = rs.getInt("quantity");
                int pavailability = rs.getInt("availability");
                Product p = new Product(
                        pid,
                        pquantity,
                        pavailability,
                        pname,
                        pcategory,
                        pbrand,
                        pcolor,
                        psize, 
                        pdescription,
                        pimage,
                        pdiscount,
                        pprice
                );
                list.add(p);
            }
        } catch (SQLException e) {
        }
        return list;
    }
    public List<Product> getPlistAdmin(){
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM product ";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int pid = rs.getInt("product_id");
                String pname = rs.getString("product_name");
                String pcategory = rs.getString("category");
                String pbrand = rs.getString("brand");
                String pcolor = rs.getString("color");
                String psize = rs.getString("size");
                float  pprice = rs.getFloat("price");
                String pdescription = rs.getString("product_description");
                String pimage = rs.getString("product_image");
                String pdiscount = rs.getString("discount");
                int pquantity = rs.getInt("quantity");
                int pavailability = rs.getInt("availability");
                Product p = new Product(
                        pid,
                        pquantity,
                        pavailability,
                        pname,
                        pcategory,
                        pbrand,
                        pcolor,
                        psize, 
                        pdescription,
                        pimage,
                        pdiscount,
                        pprice
                );
                list.add(p);
            }
        } catch (SQLException e) {
        }
        return list;
    }
    public List<Product> getNewlist(){
        List<Product> list = new ArrayList<>();
        String sql = "select top 4 * from product where availability=1 order by product_id desc";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int pid = rs.getInt("product_id");
                String pname = rs.getString("product_name");
                String pcategory = rs.getString("category");
                String pbrand = rs.getString("brand");
                String pcolor = rs.getString("color");
                String psize = rs.getString("size");
                float  pprice = rs.getFloat("price");
                String pdescription = rs.getString("product_description");
                String pimage = rs.getString("product_image");
                String pdiscount = rs.getString("discount");
                int pquantity = rs.getInt("quantity");
                int pavailability = rs.getInt("availability");
                Product p = new Product(
                        pid,
                        pquantity,
                        pavailability,
                        pname,
                        pcategory,
                        pbrand,
                        pcolor,
                        psize, 
                        pdescription,
                        pimage,
                        pdiscount,
                        pprice
                );
                list.add(p);
            }
        } catch (SQLException e) {
        }
        return list;
    }
    public List<Product> getClist(String cid){
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM product where category = ? and availability = 1 ";
//        System.out.println('1');
        try { 
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cid);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int pid = rs.getInt("product_id");
                String pname = rs.getString("product_name");
                String pcategory = rs.getString("category");
                String pbrand = rs.getString("brand");
                String pcolor = rs.getString("color");
                String psize = rs.getString("size");
                float  pprice = rs.getFloat("price");
                String pdescription = rs.getString("product_description");
                String pimage = rs.getString("product_image");
                String pdiscount = rs.getString("discount");
                int pquantity = rs.getInt("quantity");
                int pavailability = rs.getInt("availability");
                Product p = new Product(
                        pid,
                        pquantity,
                        pavailability,
                        pname,
                        pcategory,
                        pbrand,
                        pcolor,
                        psize, 
                        pdescription,
                        pimage,
                        pdiscount,
                        pprice
                );
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public Product getP(String cid){
        Product p = new Product();
        String sql = "SELECT * FROM product where product_id = ?";

        try { 
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cid);
//            System.out.println("hue");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int pid = rs.getInt("product_id");
                String pname = rs.getString("product_name");
                String pcategory = rs.getString("category");
                String pbrand = rs.getString("brand");
                String pcolor = rs.getString("color");
                String psize = rs.getString("size");
                float  pprice = rs.getFloat("price");
                String pdescription = rs.getString("product_description");
                String pimage = rs.getString("product_image");
                String pdiscount = rs.getString("discount");
                int pquantity = rs.getInt("quantity");
                int pavailability = rs.getInt("availability");
                p = new Product(
                        pid,
                        pquantity,
                        pavailability,
                        pname,
                        pcategory,
                        pbrand,
                        pcolor,
                        psize, 
                        pdescription,
                        pimage,
                        pdiscount,
                        pprice
                );
               
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }
    public List<Product> searchProduct(String name){
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE product_name LIKE '%" + name + "%'";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int pid = rs.getInt("product_id");
                String pname = rs.getString("product_name");
                String pcategory = rs.getString("category");
                String pbrand = rs.getString("brand");
                String pcolor = rs.getString("color");
                String psize = rs.getString("size");
                float  pprice = rs.getFloat("price");
                String pdescription = rs.getString("product_description");
                String pimage = rs.getString("product_image");
                String pdiscount = rs.getString("discount");
                int pquantity = rs.getInt("quantity");
                int pavailability = rs.getInt("availability");
                Product p = new Product(
                        pid,
                        pquantity,
                        pavailability,
                        pname,
                        pcategory,
                        pbrand,
                        pcolor,
                        psize, 
                        pdescription,
                        pimage,
                        pdiscount,
                        pprice
                );
                list.add(p);
            }
        } catch (SQLException e) {
        }
        return list;
    }
    public void updateHide(int id){
        String sql = "update product set availability =0 where product_id=?";
         try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            
        }
    }
    public void updateAvail(int id){
        String sql = "update product set availability =1 where product_id=?";
         try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            
        }
    }
    public void discount(String dis,String cate){
        String sql = "update product set discount=? where category=?";
         try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dis);
            ps.setString(2, cate);
            ps.executeUpdate();
        } catch (SQLException e) {
            
        }
    }
    public int getQuantity(String id){
        String sql = "select quantity from product where product_id = ?";
        ResultSet rs = null;
        int quantity = 0;
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(id));
            rs = ps.executeQuery();
            rs.next();
            quantity = rs.getInt("quantity");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return quantity;
    }
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        ProductDAO p =new ProductDAO();
//        p.deleteProduct(11);
//        list =p.getNewlist();
//        Product x=new Product(3,1,1, "quan", "1", "dd", "red", "M", "1", "quan", "1",1);
//        p.updateProduct(x);
//        p.updateAvail(5);
        System.out.println(Integer.toString(p.getQuantity("1")));
//        p.addProduct(x);
//           Product x=p.getP("1");
//           System.out.println(x);
//        System.out.println(list);
    }
}
