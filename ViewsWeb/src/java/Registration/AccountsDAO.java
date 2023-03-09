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

    public AccountsDTO checklogin(String email, String password, String id) throws SQLException {
//        ArrayList<AccountsDTO> list;
//        list = new ArrayList<AccountsDTO>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        AccountsDTO result = null;

        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "select * from users ";
                String where = " where ";
                  if(email != null && password != null){
                      sql += where; 
                      sql += " email = ? and password = ?";
                      where = " and ";
                  }
                  if(id != null){
                      sql += where; 
                      sql += " id = ? ";
                      where = " and ";
                  }
                stm = con.prepareStatement(sql);
                int index = 1;
                if(email != null && password != null){
                    stm.setString(index, email);
                    index++;
                    stm.setString(index, password);
                    index++;
                  }
                 if(id != null){
                    stm.setString(index, id);
                 }
                rs = stm.executeQuery();
                if (rs.next()) {
                    result = new AccountsDTO(rs.getInt(1),
                                             rs.getString(2),
                                             rs.getString(3),
                                             rs.getString(4),
                                             rs.getString(5),
                                             rs.getString(6),
                                             rs.getString(7),
                                             rs.getString(8),
                                             rs.getString(9),
                                             rs.getString(10),
                                             rs.getString(11)
                    );
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
    
<<<<<<< HEAD
    public boolean addAccount(int id, String email, String password, String firstname, String lastname,String Dob, String country, String city, String phone, String gender, String role){
        boolean r = false;
        try {
            Connection con = DBHelper.getConnection();
            String sql = "insert into users (email, [password], first_name, last_name, DoB, gender, [role] ) \n"
                    + "values ("
                    + "?, ?, ?, ?, ?, ?, ?)";
=======
    public boolean addAccount(int id, String email, String password, String firstname, String lastname, String country, String city, String phone, String gender, String role){
        boolean r = false;
        try {
            Connection con = DBHelper.getConnection();
            String sql = "insert into users (email, [password], first_name, last_name, country, city, phone, gender, [role] ) \n"
                    + "values ("
                    + "?, ?, ?, ?, ?, ?, ?, ?, ? )";
>>>>>>> main
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, email);
            stm.setString(2, password);
            stm.setString(3, firstname);
            stm.setString(4, lastname);
<<<<<<< HEAD
            stm.setString(5, Dob);
            stm.setString(6, gender);
            stm.setString(7, role);
            System.out.println(email);
            int rs = stm.executeUpdate();
            if (rs > 0 ){
=======
            stm.setString(5, country);
            stm.setString(6, city);
            stm.setString(7, phone);
            stm.setString(8, gender);
            stm.setString(9, role);
            System.out.println(email);
            int rs = stm.executeUpdate();
            System.out.println(rs);
            if(rs!= 0 ){
>>>>>>> main
                r =true;
            } else {
                r =false;
            }
        } catch (SQLException e) {
        }
        return r;
    }
    
    public String checkEmail(String email) throws SQLException {
//        ArrayList<AccountsDTO> list;
//        list = new ArrayList<AccountsDTO>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String result = null;

        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "select * from users ";
                String where = " where ";
                  if(email != null){
                      sql += where; 
                      sql += " email = ? ";
                      where = " and ";
                  }
                  
                stm = con.prepareStatement(sql);
                int index = 1;
                if(email != null ){
                    stm.setString(index, email);
                    index++;
                   
                rs = stm.executeQuery();
                if (rs.next()) {
                   result =  rs.getString("email");
                }
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
