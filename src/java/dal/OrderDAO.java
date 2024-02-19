/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cart;
import model.Customer;
import model.Item;

/**
 *
 * @author AD
 */
public class OrderDAO extends DBContext{
    
    public void addOrder(Customer c, Cart cart){
         LocalDate curDate = java.time.LocalDate.now();
         String date = curDate.toString();
         //add vao bang Order
         String sql = "INSERT INTO [Order] VALUES(?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(date));
            ps.setInt(2, c.getId());
            ps.setFloat(3, cart.getTotalMoney());
            
            ResultSet rs = ps.executeQuery();
            
            //lay ra id cua Order vua add
            String sql2 ="SELECT TOP 1 id FROM [Order] ORDER BY id DESC";
            PreparedStatement ps2 = connection.prepareStatement(sql2);
            ResultSet rs2 = ps2.executeQuery();
            
            if(rs2.next()){
                int oid = rs.getInt(1);
                for (Item i : cart.getItems()) {
                    String sql3 = "INSERT INTO [OrderLine] VALUES(?,?,?,?)";
                    PreparedStatement ps3 = connection.prepareStatement(sql3);
                    ps3.setInt(1, oid);
                    ps3.setInt(2, i.getProduct().getId());
                    ps3.setInt(3, i.getQuantity());
                    ps3.setFloat(4, i.getPrice());
                    
                    ps3.executeUpdate();
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
