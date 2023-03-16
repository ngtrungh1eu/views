/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration;

import Mylib.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author khong
 */
public class OrdersDAO implements Serializable {

    public List<OrdersDTO> load() {
        ArrayList<OrdersDTO> list = new ArrayList<>();
        PreparedStatement stm;
        ResultSet rs;
        OrdersDTO result;
        try {
            Connection con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT * FROM [Order] join [OrderLine] on [Order].[id] = [OrderLine].[orderid]";
                String where = " where ";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int orderid = rs.getInt("orderid");
                    int userid = rs.getInt("userid");
                    String username = rs.getString("username");
                    String phone = rs.getString("phone");
                    String address = rs.getString("address");
                    Date date = rs.getDate("date");
                    double totalmoney = rs.getDouble("totalmoney");
                    int productid = rs.getInt("productid");
                    int quantity = rs.getInt("quantity");
                    double price = rs.getDouble("price");
                    String status = rs.getString("status");
                    result = new OrdersDTO(orderid, userid, username, phone, address, date, totalmoney, productid, quantity, price, status);
                    list.add(result);
                }
                return list;
            }
        } catch (Exception e) {
        }
        return null;

    }

    public boolean delete(int id) {
        PreparedStatement stm;
        ResultSet rs;
        try {
            Connection con = DBHelper.getConnection();
            if (con != null) {
                String sql = " DELETE FROM [Order] WHERE id = ? ";
                sql += " DELETE FROM [OrderLine] WHERE orderid = ? ";
                stm = con.prepareStatement(sql);
                stm.setInt(1, id);
                stm.setInt(2, id);
                if (stm.executeUpdate() > 0) {
                    return true;
                } 
            }
        } catch (Exception e) {
        }
        return false;

    }
}
