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
"           ,[product_image])" +
"     VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getProductID());
            ps.setString(2, p.getName());
            ps.setString(3, p.getCategory());
            ps.setString(4, p.getBrand());
            ps.setString(5, p.getColor());
            ps.setString(6, p.getSize());
            ps.setLong(7, p.getPrice());
            ps.setString(8, p.getDescription());
            ps.setString(9, p.getImage());
            ps.executeUpdate();
        } catch (SQLException e) {
            
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
" WHERE [product_id] = ?";
         try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setString(2, p.getCategory());
            ps.setString(3, p.getBrand());
            ps.setString(4, p.getColor());
            ps.setString(5, p.getSize());
            ps.setLong(6, p.getPrice());
            ps.setString(7, p.getDescription());
            ps.setString(8, p.getImage());
            ps.setInt(9, p.getProductID());

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
        }
    }
    
    public List<Product> getPlist(){
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM product";
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
                long  pprice = rs.getLong("price");
                String pdescription = rs.getString("product_description");
                String pimage = rs.getString("product_image");
                Product p = new Product(
                        pid,
                        pname,
                        pcategory,
                        pbrand,
                        pcolor,
                        psize,
                        pprice,
                        pdescription,
                        pimage
                );
                list.add(p);
            }
        } catch (SQLException e) {
        }
        return list;
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
                long  pprice = rs.getLong("price");
                String pdescription = rs.getString("product_description");
                String pimage = rs.getString("product_image");
                Product p = new Product(
                        pid,
                        pname,
                        pcategory,
                        pbrand,
                        pcolor,
                        psize,
                        pprice,
                        pdescription,
                        pimage
                );
                list.add(p);
            }
        } catch (SQLException e) {
        }
        return list;
    }
    
}
