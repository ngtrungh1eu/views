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
<<<<<<< HEAD
         try {
             Connection con =  DBHelper.getConnection();
             if(con != null){
                 String sql = "select * from products join Categories on products.CateID = Categories.CateID ";
                 String where = " where ";
                 if (brandValue != null){
                     sql += where;
                     sql += " BrandName = ? ";
                     where = " and ";
                     System.out.println("dmm");
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
                     String brand = rs.getString("brandName");
                     int saleof = rs.getInt("SaleOff");
                     int quantity = rs.getInt("Quantity");
                     result = new ProductsDTO(product_id, product_name, price, image, brand, cateID, type, saleof, quantity);
                     list.add(result);
                    
                 }
                 return list;
             }
         } catch (SQLException e) {
         }
         return null;
     }
    
=======
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
                    String brand = rs.getString("brandName");
                    int saleof = rs.getInt("SaleOff");
                    int quantity = rs.getInt("Quantity");
                    result = new ProductsDTO(product_id, product_name, price, image, brand, cateID, type, saleof, quantity);
                    list.add(result);

                }
                return list;
            }
        } catch (SQLException e) {
        }
        return null;
    }

>>>>>>> 6b60b410b0a9efaada69eda378b6a3ccfac5b61a
    public ProductsDTO getProductByid(int id) {
        ArrayList<ProductsDTO> list;
        list = new ArrayList<ProductsDTO>();
        PreparedStatement stm = null;
        ResultSet rs = null;
        ProductsDTO result = null;
        try {
            Connection con = DBHelper.getConnection();
            if (con != null) {
                String sql = "select * from products join Categories on products.CateID = Categories.CateID "
                        + "where id = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, id);
                rs = stm.executeQuery();
                if (rs.next()) {
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
        } catch (SQLException e) {
        }
        return result;

    }

    public ProductsDTO getProduct(String pId) {

        ProductsDTO p = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            Connection con = DBHelper.getConnection();
            if (con != null) {
//                String sql = "select * FROM products ";
                String sql = "select * FROM products join ProductDetails on products.ID = ProductDetails.pID join Categories on products.CateID = Categories.CateID";
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
                    String brand = rs.getString("brandName");
                    String type = rs.getString("Type");
                    int saleoff = rs.getInt("SaleOff");
                    String image1 = rs.getString("Image1");
                    String image2 = rs.getString("Image2");
                    String image3 = rs.getString("Image3");
                    String image4 = rs.getString("Image4");
                    String detail = rs.getString("Details");
                    p = new ProductsDTO(product_id, product_name, price, image, image1, image2, image3, image4, brand, cateID, type, saleoff, detail, price);

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
                String sql = " select * from products ";
                String where = " where ";
                if (min != null) {
                    sql += where;
                    sql += " newPrice > ? ";
                    where = " and ";
                }

                if (max != null) {
                    sql += where;
                    sql += " newPrice < ? ";
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
                    list.add(result);
                }
                return list;
            }
        } catch (SQLException e) {
        }
        return null;

    }

    public List<ProductsDTO> load(String search) {
        ArrayList<ProductsDTO> list;
        list = new ArrayList<ProductsDTO>();
        PreparedStatement stm = null;
        ResultSet rs = null;
        ProductsDTO result = null;
        try {
            Connection con = DBHelper.getConnection();
            if (con != null) {
                String sql = " select * from products join Categories on products.CateID = Categories.CateID ";
                String where = " where ";
                if (search != null) {
                    sql += where;
                    sql += " Name like ? ";
                    where = " and ";
                }
                stm = con.prepareStatement(sql);
                int index = 1;
                if (search != null) {
                    stm.setString(index, "%" + search + "%");
                    index++;
                }
                rs = stm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("ID");
                    String name = rs.getString("Name");
                    double price = rs.getDouble("Price");
                    String image = rs.getString("image");
                    int cate = rs.getInt("CateID");
                    String type = rs.getString("Type");
                    int saleoff = rs.getInt("SaleOff");
                    String brand = rs.getString("BrandName");
//                    double newPrice = rs.getDouble("newPrice");
                    result = new ProductsDTO(id, name, price, image, brand, cate, type, saleoff, price);
                    list.add(result);
                }
                return list;
            }
        } catch (Exception e) {
        }

        return null;

    }

    public Long insert(ProductsDTO product) {
        PreparedStatement stm;
        ResultSet rs;
        String sql = " INSERT INTO products( ID, Name, Price, Image, CateID, Type, SaleOff) VALUES (?, ?, ?, ?, ?, ?, ?) ";
        try {
            Connection con = DBHelper.getConnection();
            stm = con.prepareStatement(sql);
            stm.setInt(1, product.getProduct_id());
            stm.setString(2, product.getProduct_name());
            stm.setDouble(3, product.getPrice());
            stm.setString(4, product.getImage());
            stm.setInt(5, product.getCate_id());
            stm.setString(6, product.getType());
            stm.setFloat(7, product.getSaleoff());
            stm.executeUpdate();
        } catch (Exception e) {
        }

        return null;

    }

    public boolean delete(Long id) {
        ProductsDTO product;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            Connection con = DBHelper.getConnection();
            if (con != null) {
                String sql = " DELETE FROM products WHERE id = ? ";
                String where = " where ";
                stm = con.prepareStatement(sql);
                stm.setLong(1, id);
                if (stm.executeUpdate() > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public ProductsDTO update(ProductsDTO product) {
        PreparedStatement stm;
        ResultSet rs;
        String sql = " update products set ID = ?, Name = ? , Price = ?, Image = ?, CateID = ?, Type = ?, SaleOff = ? WHERE ID = ? ";
        try {
            Connection con = DBHelper.getConnection();
            stm = con.prepareStatement(sql);
            stm.setInt(1, product.getProduct_id());
            stm.setString(2, product.getProduct_name());
            stm.setDouble(3, product.getPrice());
            stm.setString(4, product.getImage());
            stm.setInt(5, product.getCate_id());
            stm.setString(6, product.getType());
            stm.setFloat(7, product.getSaleoff());
            stm.setInt(8, product.getProduct_id());
            if (stm.executeUpdate() > 0) {
                System.out.println("update dung");
            } else {
                System.out.println("update loi me roi");
            }
        } catch (Exception e) {
        }
        return product;
    }

    public ProductsDTO load(Long id) {
        String sql = "select * from products where id = ?";
        try {
            Connection con = DBHelper.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setLong(1, id);
            ProductsDTO result = null;
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int pId = rs.getInt("ID");
                String name = rs.getString("Name");
                double price = rs.getDouble("Price");
                String image = rs.getString("image");
                String type = rs.getString("Type");
                int saleoff = rs.getInt("SaleOff");
                int cate = rs.getInt("CateID");
                result = new ProductsDTO(pId, name, price, image, cate, type, saleoff);
            }
            System.out.println(result);
            return result;
        } catch (SQLException ex) {
            System.out.println("Query Student error!" + ex.getMessage());
        }
        return null;
    }
    
    public List<ProductsDTO> getListByPage(List<ProductsDTO> list, int start, int end){
        ArrayList<ProductsDTO> arr = new ArrayList<>();
        for(int i = start; i<end;i++){
            arr.add(list.get(i));
        }
        return arr;
    }
}
