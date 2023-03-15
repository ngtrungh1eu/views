/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration;

import Mylib.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author ROG
 */
public class OrdersDAO {
    public void addOder(AccountsDTO customer, CartsDTO cart){
        LocalDate curDate = LocalDate.now();
        String date = curDate.toString();
        try {
            Connection con =  DBHelper.getConnection();
            String sql = "insert into [Order] values (?,?,?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, date);
            stm.setInt(2, customer.getUser_id());
            stm.setString(3, customer.getLast_name());
            stm.setString(4, customer.getPhone());
            stm.setString(5, customer.getCity());
            stm.setDouble(6, cart.getTotalMoney());
            stm.executeUpdate();
            //
            String sql1 = "select top 1 id from [Order] order by id desc";
            PreparedStatement stm1 = con.prepareStatement(sql1);
            ResultSet  rs = stm1.executeQuery();
            if(rs.next()){
                int oderid = rs.getInt("id");
                for(ItemsDTO i:cart.getItems()){
                    String sql2="insert into [OrderLine] values (?,?,?,?,?)";
                    PreparedStatement stm2 = con.prepareStatement(sql2);
                    stm2.setInt(1, oderid);
                    stm2.setInt(2, i.getProduct().getProduct_id());
                    stm2.setInt(3, i.getQuantity());
                    stm2.setDouble(4, i.getPrice());
                    stm2.setString(5, "Paid");
                    stm2.executeUpdate();
                }
            }
            //cap nhta so luong
            String sql3 = "update products set Quantity = Quantity-? where ID = ?";
            PreparedStatement stm3 = con.prepareStatement(sql3);
            for (ItemsDTO i : cart.getItems()) {
                stm3.setInt(1, i.getQuantity());
                stm3.setInt(2, i.getProduct().getProduct_id());
                stm3.executeUpdate();
            }
        } catch (SQLException e) {
        }
    }
}
