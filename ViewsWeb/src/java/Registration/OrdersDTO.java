/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration;

import java.sql.Date;

/**
 *
 * @author ROG
 */
public class OrdersDTO {

    private int orderid;
    private int userid;
    private String username;
    private String phone;
    private String address;
    private Date date;
    private double totalmoney;
    private int productid;
    private int quantity;
    private double price;
    private String status;

    public OrdersDTO() {
    }

    public OrdersDTO(int orderid, int userid, String username, String phone, String address, Date date, double totalmoney, int productid, int quantity, double price, String status) {
        this.orderid = orderid;
        this.userid = userid;
        this.username = username;
        this.phone = phone;
        this.address = address;
        this.date = date;
        this.totalmoney = totalmoney;
        this.productid = productid;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
    }

    
    
    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(double totalmoney) {
        this.totalmoney = totalmoney;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

}
