/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ROG
 */
public class CartsDTO {
    private List<ItemsDTO> items;
    
    public CartsDTO() {
        items = new ArrayList<>();
    }
    
    public List<ItemsDTO> getItems(){
        return items;
    }

    private ItemsDTO getItemById(int id){
        for (ItemsDTO i : items){
            if(i.getProduct().getProduct_id() == id){
                return i;
            }
        }
        return null;
    }
    
    public int getQuantitybyId(int id){
        return getItemById(id).getQuantity();
    }
    
    public void addItems(ItemsDTO t){
        if(getItemById(t.getProduct().getProduct_id()) != null){
            ItemsDTO m = getItemById(t.getProduct().getProduct_id());
            m.setQuantity(m.getQuantity()+t.getQuantity());
        } else {
            items.add(t);
        }
    }
    
    public void removeItem(int id){
        if(getItemById(id) != null){
            items.remove(getItemById(id));
        }
    }
    
    public double getTotalMoney(){
        double total = 0;
        for (ItemsDTO i : items) {
            total += (i.getQuantity()*i.getPrice());
        }
        return total;
    }
    private ProductsDTO getProductById(int id, List<ProductsDTO> list){
        for (ProductsDTO o : list) {
            if(o.getProduct_id() == id){
                return o;
            }
        }
        return null;
    }
    
    public CartsDTO(String txtCookie, List<ProductsDTO> list ){
        items = new ArrayList<>();
        try {
            if(txtCookie != null && txtCookie.length() !=0){
            String[] Cookie = txtCookie.split(",");
            for (String i : Cookie) {
                String[] eachCookie = i.split(":");
                int user_id = Integer.parseInt(eachCookie[0]);
                String eachCookie1 = eachCookie[1];
                String[] eachDetail = eachCookie1.split("-");
                int id = Integer.parseInt(eachDetail[0]);
                int quantity = Integer.parseInt(eachDetail[1]);
                ProductsDTO p = getProductById(id, list);
                ItemsDTO t = new ItemsDTO(p, quantity, p.getNewPrice(), user_id);
                addItems(t);
            }
        }
        } catch (NumberFormatException e) {
    }
    }
}
