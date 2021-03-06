package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.OrderItem;

public class OrderItemDAO extends DAO{
    public void addItem(OrderItem item){
        String sql = "INSERT INTO [dbo].[order_item]" +
"           ([order_id]" +
"           ,[product_id]" +
"           ,[quantity]" +
"           ,[discount]" +
"           ,[price])" +
"     VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, item.getOrderID());
            ps.setInt(2, item.getProductID());
            ps.setLong(3, item.getQuantity());
            ps.setString(4, item.getDiscount());
            ps.setFloat(5, item.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
e.printStackTrace();
        }
    }
    public void updateItem(OrderItem item){
        String sql = "UPDATE order_item SET product_id = ?, quantity = ?, discount = ?, price = ? "
                + "WHERE item_id = ? AND order_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, item.getProductID());
            ps.setInt(2, item.getQuantity());
            ps.setString(3, item.getDiscount());
            ps.setFloat(4, item.getPrice());
            ps.setInt(5, item.getItemID());
            ps.setInt(6, item.getOrderID());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    public void removeItem(int id){
        String sql = "DELETE FROM order_item WHERE order_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public List<OrderItem> getItemList(){
        List<OrderItem> list = new ArrayList<>();
        String sql = "SELECT * FROM order_item";
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {                
                OrderItem i = new OrderItem(
                        rs.getInt("item_id"),
                        rs.getInt("order_id"),
                        rs.getInt("product_id"),
                        rs.getInt("quantity"),
                        rs.getString("discount"),
                        rs.getFloat("price")
                );
                list.add(i);
            }
        }catch(SQLException e){}
        return list;
    }
}
