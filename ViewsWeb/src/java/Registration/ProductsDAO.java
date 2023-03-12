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
public class ProductsDAO implements Serializable{
    public List<ProductsDTO> getList(String brandValue, String typeValue, String searchValue){
        ArrayList<ProductsDTO> list;  
        list = new ArrayList<ProductsDTO>();
        PreparedStatement stm = null;
        ResultSet rs = null;
        ProductsDTO result = null;
         try {
             Connection con =  DBHelper.getConnection();
             if(con != null){
                 String sql = "select * from products join Categories on products.CateID = Categories.CateID ";
                 String where = " where ";
                 if (brandValue != null){
                     sql += where;
                     sql += " BrandName = ? ";
                     where = " and ";
                 }
                 if (searchValue != null){
                     sql += where;
                     sql += " [Name] like ? ";
                     where = " and ";
                 }
                 if (typeValue != null){
                     sql += where;
                     sql += " Type  = ? ";
                     where = " and ";
                 }
                 stm = con.prepareStatement(sql);
                 int index = 1;
                 if (brandValue != null){
                     stm.setString(index, brandValue);
                     index ++; 
                 }
                 if (searchValue != null){
                     stm.setString(index, "%" + searchValue + "%");
                     index ++; 
                 }
                 if (typeValue != null ){
                     stm.setString(index, typeValue);
                     index ++;
                 }
                 rs =stm.executeQuery();
                 while (rs.next()){
                     int product_id = rs.getInt("ID");
                     String product_name = rs.getString("Name");
                     double price = rs.getDouble("Price");
                     String image = rs.getString("Image");
                     int cateID = rs.getInt("CateID");
                     String type = rs.getString("Type");
                     int saleof = rs.getInt("SaleOff");
                     result = new ProductsDTO(product_id, product_name, price, image, cateID, type, saleof);
                     System.out.println(rs.getString("Image"));
                     list.add(result);
                     System.out.println(list.get(0));
                    
                 }
                 return list;
             }
         } catch (SQLException e) {
         }
         return null;
     }
    
    public ProductsDTO getProductByid(int id){
        ArrayList<ProductsDTO> list;  
        list = new ArrayList<ProductsDTO>();
        PreparedStatement stm = null;
        ResultSet rs = null;
        ProductsDTO result = null;
         try {
            Connection con =  DBHelper.getConnection();
             if(con != null){
                 String sql = "select * from products join Categories on products.CateID = Categories.CateID "
                         + "where id = ?";
                 stm = con.prepareStatement(sql);
                 stm.setInt(1, id);
                 rs = stm.executeQuery();
                 if(rs.next()){
                    int product_id = rs.getInt("ID");
                     String product_name = rs.getString("Name");
                     double price = rs.getDouble("Price");
                     String image = rs.getString("Image");
                     int cateID = rs.getInt("CateID");
                     String type = rs.getString("Type");
                     int saleof = rs.getInt("SaleOff");
                     String brand = rs.getString("brandName");
                     int quantity = rs.getInt("Quantity");
                     result = new ProductsDTO(product_id, product_name, price, image, brand, cateID, type, saleof, quantity);
                     
                 }
                 }
        } catch (Exception e) {
        }
         return result;
             
    }
}
