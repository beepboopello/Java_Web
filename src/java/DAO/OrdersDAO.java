package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Orders;

public class OrdersDAO extends DAO {

    public void addOrder(Orders o) {
        String sql
                = "INSERT INTO [dbo].[orders]"
                + "           ([order_id]"
                + "           ,[customer_id]"
                + "           ,[store_id]"
                + "           ,[seller_id]"
                + "           ,[order_date]"
                + "           ,[status])"
                + "     VALUES"
                + "           (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, o.getOrderID());
            ps.setInt(2, o.getCustomerID());
            ps.setInt(3, o.getStoreID());
            ps.setInt(4, o.getSellerID());
            ps.setString(5, o.getOrder_date());
            ps.setString(6, o.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public void updateOrder(Orders o) {
        String sql
                = "UPDATE [dbo].[orders]"
                + "SET "
                + "           ,[customer_id] = ?"
                + "           ,[store_id] = ?"
                + "           ,[seller_id] = ?"
                + "           ,[order_date] = ?"
                + "           ,[status] = ?)"
                + "     WHERE"
                + "           [order_id] = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(6, o.getOrderID());
            ps.setInt(1, o.getCustomerID());
            ps.setInt(2, o.getStoreID());
            ps.setInt(3, o.getSellerID());
            ps.setString(4, o.getOrder_date());
            ps.setString(5, o.getStatus());
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public void updateStatus(int id, String status) {
        String sql
                = "UPDATE [dbo].[orders]"
                + "SET "
                + "           ,[status] = ?)"
                + "     WHERE"
                + "           [order_id] = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public void removeOrder(int id) {
        String sql = "DELETE FROM orders WHERE order_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public List<Orders> getListOrders() {
        List<Orders> list = new ArrayList<>();
        String sql = "SELECT * FROM orders";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int oid = rs.getInt("order_id");
                int cid = rs.getInt("customer_id");
                int sid = rs.getInt("store_id");
                int slid = rs.getInt("seller_id");
                String odate = rs.getString("order_date");
                String ostatus = rs.getString("status");
                Orders o = new Orders(oid, cid, sid, slid, odate, ostatus);
                list.add(o);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public static void main(String[] args) {
        OrdersDAO odao = new OrdersDAO();
        try{
        odao.addOrder(new Orders(1,2,3,4,"11/05/2212","pending"));
            System.out.println("okay");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
