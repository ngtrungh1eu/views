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
public class ItemsDTO {
    private ProductsDTO product;
    private int quantity;
    private double price;
    private int user_id;

    public ItemsDTO() {
    }

    public ItemsDTO(ProductsDTO product, int quantity, double price, int user_id) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.user_id = user_id;
    }

    public ProductsDTO getProduct() {
        return product;
    }

    public void setProduct(ProductsDTO product) {
        this.product = product;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    
    
}
