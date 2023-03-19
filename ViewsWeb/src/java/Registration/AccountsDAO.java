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
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ROG
 */
public class AccountsDAO implements Serializable {

    public List<AccountsDTO> getList(String searchUser) throws SQLException {
        ArrayList<AccountsDTO> list = new ArrayList<AccountsDTO>();
        PreparedStatement stm = null;
        Connection con = null;
        ResultSet rs = null;
        AccountsDTO result = null;
        String keyValue = " %" + searchUser + "%";
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = " SELECT *from users WHERE role = 'user'";
                String where = "";

                if (searchUser != null) {
                    where = " where ";
                    sql += where;
                    sql += "first_name like ?";
                }
                stm = con.prepareStatement(sql);
                if (searchUser != null) {
                    stm.setString(1, keyValue);
                }
                rs = stm.executeQuery();
                while (rs.next()) {
                    int User_id = rs.getInt("id");
                    String Email = rs.getString("email");
                    String Password = rs.getString("password");
                    String setFirst_name = rs.getString("first_name");
                    String setLast_name = rs.getString("last_name");
                    LocalDate Dob = rs.getDate("DoB").toLocalDate();
                    String Country = rs.getString("country");
                    String City = rs.getString("city");
                    String Phone = rs.getString("phone");
                    String Gender = rs.getString("gender");
                    String Role = rs.getString("role");
                    result = new AccountsDTO(User_id, Email, Password, setFirst_name, setLast_name, Dob, Country, City,
                            Phone, Gender, Role);
                    list.add(result);
                    // System.out.println(result.getDob());
                    // System.out.println("yyy");

                }

                return list;

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
        return list;

    }

    public List<AccountsDTO> getList() throws SQLException {
        ArrayList<AccountsDTO> list = new ArrayList<AccountsDTO>();
        PreparedStatement stm = null;
        Connection con = null;
        ResultSet rs = null;
        AccountsDTO result = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT * from users";
                stm = con.prepareStatement(sql);

                rs = stm.executeQuery();
                System.out.println("yyy");
                while (rs.next()) {

                    int User_id = rs.getInt("id");
                    String Email = rs.getString("email");
                    String Password = rs.getString("password");
                    String setFirst_name = rs.getString("first_name");
                    String setLast_name = rs.getString("last_name");
                    LocalDate Dob = rs.getDate("DoB").toLocalDate();

                    String Country = rs.getString("country");
                    String City = rs.getString("city");
                    String Phone = rs.getString("phone");
                    String Gender = rs.getString("gender");
                    String Role = rs.getString("role");
                    result = new AccountsDTO(User_id, Email, Password, setFirst_name, setLast_name, Dob, Country, City,
                            Phone, Gender, Role);
                    list.add(result);
                    // System.out.println(result.getDob());
                    // System.out.println("yyy");

                }
                System.out.println(list);
                return list;

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
        return list;

    }

    public AccountsDTO checklogin(String email, String password, String id) throws SQLException {
        // ArrayList<AccountsDTO> list;
        // list = new ArrayList<AccountsDTO>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        AccountsDTO result = null;

        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "select * from users ";
                String where = " where ";
                if (email != null && password != null) {
                    sql += where;
                    sql += " email = ? and password = ?";
                    where = " and ";
                }
                if (id != null) {
                    sql += where;
                    sql += " id = ? ";
                    where = " and ";
                }
                stm = con.prepareStatement(sql);
                int index = 1;
                if (email != null && password != null) {
                    stm.setString(index, email);
                    index++;
                    stm.setString(index, password);
                    index++;
                }
                if (id != null) {
                    stm.setString(index, id);
                }
                rs = stm.executeQuery();
                if (rs.next()) {
                    result = new AccountsDTO(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getDate(6).toLocalDate(),
                            rs.getString(7),
                            rs.getString(8),
                            rs.getString(9),
                            rs.getString(10),
                            rs.getString(11));
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

    public boolean updateAccount(String id, String email, String password, String firstname, String lastname, String Dob, String country, String city, String phone, String gender, String role) {
        boolean r = false;
        try {
            Connection con = DBHelper.getConnection();

            String sql2 = "UPDATE users SET first_name=?, last_name=?, DoB=?, country=?, city=?, phone=?, gender=? WHERE email =? AND password =?";

            PreparedStatement stm2 = con.prepareStatement(sql2);

            stm2.setString(1, firstname);
            stm2.setString(2, lastname);
            stm2.setString(3, Dob);
            stm2.setString(4, country);
            stm2.setString(5, city);

            stm2.setString(6, phone);
            stm2.setString(7, gender);
            stm2.setString(8, email);
            stm2.setString(9, password);

            System.out.println(email);
            int rs2 = stm2.executeUpdate();
            if (rs2 > 0) {
                r = true;
            } else {
                r = false;
            }
        } catch (SQLException e) {
        }
        return r;
    }

    

    public boolean addAccount(int id, String email, String password, String firstname, String lastname, String Dob, String country, String city, String phone, String gender, String role) {
        boolean r = false;
        try {
            Connection con = DBHelper.getConnection();
            String sql = "insert into users (email, [password], first_name, last_name, DoB, gender, [role] ) \n"
                    + "values ("
                    + "?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, email);
            stm.setString(2, password);
            stm.setString(3, firstname);
            stm.setString(4, lastname);
            stm.setString(5, Dob);
            stm.setString(6, gender);
            stm.setString(7, role);
            int rs = stm.executeUpdate();
            if (rs > 0) {
                r = true;
            } else {
                r = false;
            }
        } catch (SQLException e) {
        }
        return r;
    }

    public String checkEmail(String email) throws SQLException {
        // ArrayList<AccountsDTO> list;
        // list = new ArrayList<AccountsDTO>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String result = null;

        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "select * from users ";
                String where = " where ";
                if (email != null) {
                    sql += where;
                    sql += " email = ? ";
                    where = " and ";
                }

                stm = con.prepareStatement(sql);
                int index = 1;
                if (email != null) {
                    stm.setString(index, email);
                    index++;

                    rs = stm.executeQuery();
                    if (rs.next()) {
                        result = rs.getString("email");
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

    public List<AccountsDTO> getUser(String searchUser) throws SQLException {
        ArrayList<AccountsDTO> UserList = new ArrayList<AccountsDTO>();
        PreparedStatement stm = null;
        Connection con = null;
        ResultSet rs = null;
        AccountsDTO result = null;
        String keyValue = "%" + searchUser + "%";
        try {

            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT *from users";
                String where = "";

                if (searchUser != null) {
                    where = " where ";
                    sql += where;
                    sql += "first_name like ?";
                }
                stm = con.prepareStatement(sql);
                if (searchUser != null) {
                    stm.setString(1, keyValue);
                }

                rs = stm.executeQuery();

                while (rs.next()) {

                    int User_id = rs.getInt("id");
                    String Email = rs.getString("email");
                    String Password = rs.getString("password");
                    String setFirst_name = rs.getString("first_name");
                    String setLast_name = rs.getString("last_name");
                    LocalDate Dob = rs.getDate("DoB").toLocalDate();

                    String Country = rs.getString("country");
                    String City = rs.getString("city");
                    String Phone = rs.getString("phone");
                    String Gender = rs.getString("gender");
                    String Role = rs.getString("role");
                    result = new AccountsDTO(User_id, Email, Password, setFirst_name, setLast_name, Dob, Country, City,
                            Phone, Gender, Role);
                    UserList.add(result);
                }
                System.out.println(UserList);

                return UserList;

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
        return UserList;

    }

    public boolean delete(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        try {

            Connection conn = DBHelper.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            if (ps.executeUpdate() > 0)
                return true;
            else
                return false;

        } catch (SQLException ex) {

        }

        return false;
    }
}


