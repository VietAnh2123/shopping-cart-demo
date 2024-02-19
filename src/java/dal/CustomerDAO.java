/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;

/**
 *
 * @author AD
 */
public class CustomerDAO extends DBContext {

    public Customer getAccount(String username, String password) {
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[amount]\n"
                + "      ,[username]\n"
                + "      ,[password]\n"
                + "  FROM [CartDB].[dbo].[Customer] "
                + "  WHERE username=? AND password=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Customer c = new Customer(rs.getInt(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4),
                        rs.getString(5));

                return c;
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
