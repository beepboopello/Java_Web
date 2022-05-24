package DAO;

import model.Store;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class StoreDAO extends DAO{
    public void addStore(Store store){
        String sql = "INSERT INTO [dbo].[store]" +
"           ([store_id]" +
"           ,[name]" +
"           ,[address])" +
"     VALUES (?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, store.getStoreID());
            ps.setString(2, store.getName());
            ps.setString(3, store.getAddress());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    public void updateStore(Store store){
        String sql = "UPDATE store SET name = ? , address = ? WHERE store_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, store.getName());
            ps.setString(2, store.getAddress());
            ps.setInt(3, store.getStoreID());
        } catch (Exception e) {
        }
    }
    public void removeStore(int id){
        String sql = "DELETE FROM store WHERE store_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    public List<Store> getStoreList() {
        List<Store> list = new ArrayList<>();
        String sql = "SELECT * FROM store";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Store store = new Store(rs.getInt("store_id"), rs.getString("name"), rs.getString("address"));
                list.add(store);
            }
        } catch (SQLException e) {
        }
        return list;
    }
}
