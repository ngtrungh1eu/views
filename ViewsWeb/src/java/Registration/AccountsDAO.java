/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration;

import Mylib.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ROG
 */
public class AccountsDAO implements Serializable {

    public AccountsDTO checklogin(String email, String password) throws SQLException {
        ArrayList<AccountsDTO> list;
        list = new ArrayList<AccountsDTO>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        AccountsDTO result = null;

        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "select * from users "
                        + "where username = ? and password = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                stm.setString(2, password);

                rs = stm.executeQuery();

                if (rs.next()) {
                    list.add(new AccountsDTO(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8),
                            rs.getString(9),
                            rs.getString(10)
                    ));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

//     public List<ViewsDTO> getListByPara(String keyword){
//        Connection con = null;
//        PreparedStatement stm = null;
//        ResultSet rs = null;
//        AccountsDTO result = null;
//         try {
//             con =  DBHelper.getConnection();
//             if(con != null){
//                 String sql = "select * from products "
//                         + "where Brand = ?";
//                 stm = con.prepareStatement(sql);
//                 stm.setString(1, keyword);
//                 rs =stm.executeQuery();
//                 
//                 while (rs.next()){
//                     int product_id = rs.getInt("ID");
//                     String product_name = rs.getString("Name");
//                     double price = rs.getDouble("Price");
//                     String image = rs.getString("Image");
//                     String brand = rs.getString("Brand");
//                     int cateID = rs.getInt("CateID");
//                     String type = rs.getString("Type");
//                     result = new AccountsDTO(product_id, product_name, price, image, brand, cateID, type);
//                     if(list == null ){
//                         list = new ArrayList<>();
//                     }
//                     list.add(result);
//                    
//                 }
//             }
//         } catch (SQLException e) {
//         }
//         return list;
//     }
    // Test ham getList()//
//     public static void main(String[] args) {
//        AccountsDAO dao = new AccountsDAO();
//        String brandValue = null;
//        List<ViewsDTO> rs= dao.getList(brandValue);
//         try {
//             for (int i = 0; i < rs.size(); i++) {
//             System.out.println(rs.get(i).getImage());
//             }
//         } catch (Exception e) {
//         }
//         
//    }
}
