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
public class ProductsDAO implements Serializable {

    public List<ProductsDTO> getList(String brandValue, String typeValue, String searchValue) {
        ArrayList<ProductsDTO> list;
        list = new ArrayList<ProductsDTO>();
        PreparedStatement stm = null;
        ResultSet rs = null;
        ProductsDTO result = null;
        try {
            Connection con = DBHelper.getConnection();
            if (con != null) {
                String sql = "select * from products join Categories on products.CateID = Categories.CateID ";
                String where = " where ";
                if (brandValue != null) {
                    sql += where;
                    sql += " BrandName = ? ";
                    where = " and ";
                }
                if (searchValue != null) {
                    sql += where;
                    sql += " [Name] like ? ";
                    where = " and ";
                }
                if (typeValue != null) {
                    sql += where;
                    sql += " Type  = ? ";
                    where = " and ";
                }
                stm = con.prepareStatement(sql);
                int index = 1;
                if (brandValue != null) {
                    stm.setString(index, brandValue);
                    index++;
                }
                if (searchValue != null) {
                    stm.setString(index, "%" + searchValue + "%");
                    index++;
                }
                if (typeValue != null) {
                    stm.setString(index, typeValue);
                    index++;
                }
                rs = stm.executeQuery();
                while (rs.next()) {
                    int product_id = rs.getInt("ID");
                    String product_name = rs.getString("Name");
                    double price = rs.getDouble("Price");
                    String image = rs.getString("Image");
                    int cateID = rs.getInt("CateID");
                    String type = rs.getString("Type");
                    int saleof = rs.getInt("SaleOff");
                    result = new ProductsDTO(product_id, product_name, price, image, cateID, type, saleof);
//                    System.out.println(rs.getString("Image"));
                    list.add(result);
//                    System.out.println(list.get(0));
                }
                return list;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public ProductsDTO getProduct(String pId) {

        ProductsDTO p = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            Connection con = DBHelper.getConnection();
            if (con != null) {
//                String sql = "select * FROM products ";
                String sql = "select * FROM products join ProductDetails on products.ID = ProductDetails.pID ";
                String where = " where ";

                if (pId != null) {
                    sql += where;
                    sql += " ID = ? ";
//                    sql += " [ID] = ? ";
                    where = " and ";
                }

                stm = con.prepareStatement(sql);
                int index = 1;

                if (pId != null) {
                    stm.setString(index, pId);
                    index++;
                }

                rs = stm.executeQuery();

                while (rs.next()) {
                    int product_id = rs.getInt("ID");
                    String product_name = rs.getString("Name");
                    double price = rs.getDouble("Price");
                    String image = rs.getString("Image");
                    int cateID = rs.getInt("CateID");
                    String type = rs.getString("Type");
                    int saleoff = rs.getInt("SaleOff");
                    String image1 = rs.getString("Image1");
                    String image2 = rs.getString("Image2");
                    String image3 = rs.getString("Image3");
                    String image4 = rs.getString("Image4");
                    String detail = rs.getString("Details");
                    p = new ProductsDTO(product_id, product_name, price, image, image1, image2, image3, image4, image, cateID, type, saleoff, detail, price);

                }
                return p;
            }
        } catch (Exception e) {
        }
        return null;

    }

    public List<ProductsDTO> getListByPrice(String min, String max) {
        ArrayList<ProductsDTO> list;
        list = new ArrayList<ProductsDTO>();
        PreparedStatement stm = null;
        ResultSet rs = null;
        ProductsDTO result = null;
        try {
            Connection con = DBHelper.getConnection();
            if (con != null) {
                String sql = "select * from products  ";
                String where = " where ";
                if (min != null) {
                    sql += where;
                    sql += " Price > ? ";
                    where = " and ";
                }

                if (max != null) {
                    sql += where;
                    sql += " Price < ? ";
                    where = " and ";
                }

                stm = con.prepareStatement(sql);
                int index = 1;
                if (min != null) {
                    stm.setString(index, min);
                    index++;
                }
                if (max != null) {
                    stm.setString(index, max);
                    index++;
                }

                rs = stm.executeQuery();
                while (rs.next()) {
                    int product_id = rs.getInt("ID");
                    String product_name = rs.getString("Name");
                    double price = rs.getDouble("Price");
                    String image = rs.getString("Image");
                    int cateID = rs.getInt("CateID");
                    String type = rs.getString("Type");
                    int saleof = rs.getInt("SaleOff");
                    result = new ProductsDTO(product_id, product_name, price, image, cateID, type, saleof);
//                    System.out.println(rs.getString("Image"));
                    list.add(result);
//                    System.out.println(list.get(0));
                }
                return list;
            }
        } catch (SQLException e) {
        }
        return null;
    }
}
