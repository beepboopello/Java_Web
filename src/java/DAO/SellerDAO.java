package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Seller;


public class SellerDAO extends DAO{
    public void addSeller (Seller s){
        String sql = "INSERT INTO seller("
                + "seller_id,"
                + "first_name,last_name,address,"
                + "email,phone,username,password,store_id)"
                + " VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, s.getSellerID());
            ps.setString(2, s.getFirstName());
            ps.setString(3, s.getLastName());
            ps.setString(4, s.getAddress());
            ps.setString(5, s.getEmail());
            ps.setString(6, s.getPhone());
            ps.setString(7, s.getUsername());
            ps.setString(8, s.getPassword());
            ps.setInt(9, s.getStoreid());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    public Seller checkSeller(String usrname, String passwrd){
        String sql = "SELECT * FROM seller WHERE username = ? AND password = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, usrname);
            ps.setString(2, passwrd);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Seller s = new Seller(
                        rs.getInt("seller_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        usrname,
                        passwrd,   
                        rs.getInt("store_id")
                );
                return s;
            }
        } catch (Exception e) {
        }
        return null;
    }
    public void updateSeller (Seller s){
        String sql = "UPDATE seller SET "
                + "first_name = ?,last_name = ?,address = ?,"
                + "email = ?,phone = ?,store_id = ? WHERE customer_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getFirstName());
            ps.setString(2, s.getLastName());
            ps.setString(3, s.getAddress());
            ps.setString(4, s.getEmail());
            ps.setString(5, s.getPhone());
            ps.setInt(6, s.getStoreid());
            ps.setInt(7, s.getSellerID());
            ps.executeUpdate();
        } catch (SQLException e) {
            
        }
    }
    
    public void removeSeller(int id){
        String sql = "delete from staffs where [staff_id]='" + id + "'";
        try {
            Statement st = conn.createStatement();
            st.executeUpdate(sql);
        } catch (SQLException ex) {
           
        }
    }
    
    public List<Seller> getSList(int id){
        List<Seller> list = new ArrayList<>();
        String sql = "SELECT * FROM seller";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {                
                int sid = rs.getInt("seller_id");
                String sfirstName = rs.getString("first_name");
                String slastName = rs.getString("last_name");
                String saddress = rs.getString("address");
                String semail = rs.getString("email");
                String sphone = rs.getString("phone");
                int storeid = rs.getInt("store_id");
                Seller s = new Seller(sid,sfirstName,slastName,saddress,semail,sphone,storeid);
                list.add(s);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public static void main(String[] args) {
        SellerDAO sldao = new SellerDAO();
        sldao.addSeller(new Seller(1,"AUwie","ISdwqe","cu wae 32 1eiurhw","awe@iewr.ewa","9343284234","aaa","ccc",4));
        
    }
}
