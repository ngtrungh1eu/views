/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration;

/**
 *
 * @author ROG
 */
public class ProductsDTO {

    private int product_id;
    private String product_name;
    private double price;
    private String image;
    private String brand;
    private int cate_id;
    private String type;
    private int saleOff;

    public ProductsDTO(int product_id, String product_name, double price, String image, String brand, int cate_id, String type, int saleOff) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.price = price;
        this.image = image;
        this.brand = brand;
        this.cate_id = cate_id;
        this.type = type;
        this.saleOff = saleOff;
    }

    public ProductsDTO() {
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSaleOff() {
        return saleOff;
    }

    public void setSaleOff(int saleOff) {
        this.saleOff = saleOff;
    }

}
