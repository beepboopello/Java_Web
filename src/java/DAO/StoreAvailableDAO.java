package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.StoreAvailable;

public class StoreAvailableDAO extends DAO {

    public void addStoreAvailable(StoreAvailable store) {
        String sql = "INSERT INTO [dbo].[store_available]"
                + "           ([store_id]"
                + "           ,[product_id]"
                + "           ,[quantity])"
                + "     VALUES(?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, store.getStoreID());
            ps.setInt(2, store.getProductID());
            ps.setInt(3, store.getQuantity());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void updateStoreAvailable(StoreAvailable store) {
        String sql = "UPDATE store_available SET product_id = ?, quantity = ? WHERE store_id =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, store.getProductID());
            ps.setInt(2, store.getQuantity());
            ps.setInt(3, store.getStoreID());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void removeStoreAvailable(int id) {
        String sql = "DELETE FROM store_available WHERE store_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    public int getQuantity(int pid, int sid){
        int quantity = 0;
        String sql = "SELECT st.quantity FROM store_available st WHERE store_id = ? AND product_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, sid);
            ps.setInt(2, pid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                quantity = rs.getInt(1);
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
        return quantity;
    }
    public List<StoreAvailable> getStoreAvailableList() {
        List<StoreAvailable> list = new ArrayList<>();
        String sql = "SELECT * FROM store_available";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                StoreAvailable store = new StoreAvailable(rs.getInt("store_id"), rs.getInt("product_id"), rs.getInt("quantity"));
                list.add(store);
            }

        } catch (SQLException e) {
        }
        return list;
    }
    public StoreAvailable getSaByid(int id){
        StoreAvailable sa = new StoreAvailable();
        String sql = "SELECT * FROM store_available where product_id = ?";
        try { 
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int said = rs.getInt("store_id");
                int sapid = rs.getInt("product_id");
                int quantity = rs.getInt("quantity");
                sa= new StoreAvailable(sapid, sapid, quantity);
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sa;
    }
    public static void main(String[] args) {
        StoreAvailableDAO x = new StoreAvailableDAO();
        StoreAvailable k=x.getSaByid(1);
        System.out.println(k);
    }
}
