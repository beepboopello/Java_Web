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
}
