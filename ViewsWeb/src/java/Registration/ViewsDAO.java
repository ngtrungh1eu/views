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
public class ViewsDAO implements Serializable{
    
    public List<ViewsDTO> list;

    public List<ViewsDTO> getList() {
        return list;
    }
    
     public ViewsDTO checklogin(String email, String password) throws SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
         ViewsDTO result = null;
        
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "select email, [password], first_name from users "
                        + "where username = ? and password = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                stm.setString(2, password);

                rs = stm.executeQuery();

                if (rs.next()) {
                    String first_name = rs.getString("first_name");
                    result = new ViewsDTO(email, password, first_name);
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
     
     public void getAll(){
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        ViewsDTO result = null;
         try {
             con =  DBHelper.getConnection();
             if(con != null){
                 String sql = "select * from products";
                 stm = con.prepareStatement(sql);
                 rs =stm.executeQuery();
                 
                 while (rs.next()){
                     int product_id = rs.getInt("ID");
                     String product_name = rs.getString("Name");
                     double price = rs.getDouble("Price");
                     String image = rs.getString("Image");
                     String brand = rs.getString("Brand");
                     int cateID = rs.getInt("CateID");
                     String type = rs.getString("Type");
                     result = new ViewsDTO(product_id, product_name, price, image, brand, cateID, type);
                     if(list == null ){
                         list = new ArrayList<>();
                     }
                     list.add(result);
                    
                 }
             }
         } catch (SQLException e) {
         }
     }
     
     // Test ham getALL()//
//     public static void main(String[] args) {
//        ViewsDAO dao = new ViewsDAO();
//        dao.getAll();
//        List<ViewsDTO> rs= dao.getList();
//         try {
//             for (int i = 0; i < rs.size(); i++) {
//             System.out.println(rs.get(i).getImage());
//             }
//         } catch (Exception e) {
//         }
//         
//    }
     
     
}
