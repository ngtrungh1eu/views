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
    private String image1;
    private String image2;
    private String image3;
    private String image4;
    private String brand;
    private int cate_id;
    private String type;
    private int saleoff;
    private String detail;
    private double newPrice;
    private int quantity;

    public ProductsDTO() {
    }

    public ProductsDTO(int product_id, String product_name, double price, String image, String image1, String image2, String image3, String image4, String brand, int cate_id, String type, int saleoff, String detail, double newPrice) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.price = price;
        this.image = image;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
        this.brand = brand;
        this.cate_id = cate_id;
        this.type = type;
        this.saleoff = saleoff;
        this.detail = detail;
        this.newPrice = newPrice;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

     
    
    public ProductsDTO(int product_id, String product_name, double price, String image, int cate_id, String type, int saleoff) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.price = price;
        this.image = image;
        this.cate_id = cate_id;
        this.type = type;
        this.saleoff = saleoff;
    }

    public ProductsDTO(int product_id, String product_name, double price, String image, String brand, int cate_id, String type, int saleoff, int quantity) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.price = price;
        this.image = image;
        this.brand = brand;
        this.cate_id = cate_id;
        this.type = type;
        this.saleoff = saleoff;
        this.quantity = quantity;
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

    public int getSaleoff() {
        return saleoff;
    }

    public void setSaleoff(int saleoff) {
        this.saleoff = saleoff;
    }
    
    public double getNewPrice() {
        return (price - (price * saleoff)/100);
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
