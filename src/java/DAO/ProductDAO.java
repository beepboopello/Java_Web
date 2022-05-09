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
            ps.setFloat(7, p.getPrice());
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
            ps.setFloat(6, p.getPrice());
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
            e.printStackTrace();
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
                float  pprice = rs.getFloat("price");
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
    public List<Product> getNewlist(){
        List<Product> list = new ArrayList<>();
        String sql = "select top 4 * from product order by product_id desc";
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
    public List<Product> getClist(String cid){
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM product where category = ?";
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
                p=new Product(pid, pname, pcategory, pbrand, pcolor, psize, pprice, pdescription, pimage);
               
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
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        ProductDAO p =new ProductDAO();
        p.deleteProduct(11);
//        list =p.getNewlist();
//        Product x=new Product(8, "quan", "1", "dd", "red", "M", 20399, "quan", "https://www.google.com/imgres?imgurl=https%3A%2F%2Fcf.shopee.vn%2Ffile%2F6b15d30647cafb56479616647af1dfa5&imgrefurl=http%3A%2F%2Fchonbachhoa.info%2Fao-baby-doll-ao-nu-dep-kieu-dang-nang-dong-tre-trung-11472.html&tbnid=ewJEcWWSbR42_M&vet=12ahUKEwjijtXgm9D3AhWfjtgFHZZwDs0QMygDegUIARC6AQ..i&docid=8T94ljs2rhEdjM&w=1024&h=1024&q=ao%20nu&ved=2ahUKEwjijtXgm9D3AhWfjtgFHZZwDs0QMygDegUIARC6AQ");
//        p.addProduct(x);
//        System.out.println(list);
    }
}
