
package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Customer;
public class CustomerDAO extends DAO{
    
    public void addCustomer (Customer c){
        String sql = "INSERT INTO customer("
                + "customer_id,"
                + "first_name,last_name,address,"
                + "email,phone,username,password)"
                + " VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, c.getCustomerID());
            ps.setString(2, c.getFirstName());
            ps.setString(3, c.getLastName());
            ps.setString(4, c.getAddress());
            ps.setString(5, c.getEmail());
            ps.setString(6, c.getPhone());
            ps.setString(7, c.getUsername());
            ps.setString(8, c.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public Customer checkCustomer(String usrname, String passwrd){
        String sql = "SELECT * FROM customer WHERE username = ? AND password = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,usrname);
            ps.setString(2, passwrd);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Customer c = new Customer(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        usrname,passwrd
                );
                return c;
            }
        } catch (SQLException e) {
        }
        return null;
    }
    
    public void updateCustomer(Customer c){
        String sql = "UPDATE customer SET "
                + "first_name = ?,last_name = ?,address = ?,"
                + "email = ?,phone = ? WHERE customer_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, c.getFirstName());
            ps.setString(2, c.getLastName());
            ps.setString(3, c.getAddress());
            ps.setString(4, c.getEmail());
            ps.setString(5, c.getPhone());
            ps.setInt(6, c.getCustomerID());
            ps.executeUpdate();
        } catch (SQLException e) {
            
        }
    }
    
    public void removeCustomer(int id){
        String sql = "DELETE FROM customer WHERE customer_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public List<Customer> getCList(){
        List<Customer> list = new ArrayList<Customer>();
        String sql = "SELECT * FROM customer";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int cid = rs.getInt("customer_id");
                String cfirstName = rs.getString("first_name");
                String clastName = rs.getString("last_name");
                String caddress = rs.getString("address");
                String cemail = rs.getString("email");
                String cphone = rs.getString("phone");
                Customer c = new Customer(cid,cfirstName,clastName,caddress,cemail,cphone);
                list.add(c);
            }          
        } catch (SQLException e) {
            
        }
        return list;
    }
    
    public Customer searchCustomer(String phone){
        Customer c = null;
        String sql = "SELECT * FROM customer WHERE phone=?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int cid = rs.getInt("customer_id");
                String cfirstName = rs.getString("first_name");
                String clastName = rs.getString("last_name");
                String caddress = rs.getString("address");
                String cemail = rs.getString("email");
                String cphone = rs.getString("phone");
                c = new Customer(cid,cfirstName,clastName,caddress,cemail,cphone);                
            }
        }catch(SQLException e){
            
        }
        return c;
    }
    public static void main(String[] args) {
        //CustomerDAO cDAO = new CustomerDAO();
            //cDAO.addCustomer(new Customer(2,"Le","Am","10, Mo Lao, Ha Dong, Ha Noi","amle10@gmul.com","0123456987","amimim","bsds"));
            System.out.println(cDAO.checkCustomer("hue","hue"));
            //cDAO.removeCustomer(1);
            //cDAO.updateCustomer(new Customer(2,"Le","Am","10, Mo Lao, Ha Dong, Ha Noi","amle10@gmul.com","0123456987"));
            //System.out.println(cDAO.checkCustomer("amimim","bsds"));
            
            /*List<Customer> a = cDAO.getCList();
            for(Customer i : a){
                System.out.println(i);
            }*/
            System.out.println("OKE");            
    }
}
