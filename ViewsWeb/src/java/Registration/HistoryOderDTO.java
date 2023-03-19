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
public class HistoryOderDTO {
    private String pID;
    private String pName;
    private double price;
    private String image;
    private int oID;
    private int Cquantity;
    private String date;
    private double total;

    public HistoryOderDTO() {
    }

    public HistoryOderDTO(String pID, String pName, double price, String image, int oID, int Cquantity, String date, double total) {
        this.pID = pID;
        this.pName = pName;
        this.price = price;
        this.image = image;
        this.oID = oID;
        this.Cquantity = Cquantity;
        this.date = date;
        this.total = total;
    }

    public String getpID() {
        return pID;
    }

    public void setpID(String pID) {
        this.pID = pID;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
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

    public int getOID() {
        return oID;
    }

    public void setOID(int oID) {
        this.oID = oID;
    }

    public int getCquantity() {
        return Cquantity;
    }

    public void setCquantity(int Cquantity) {
        this.Cquantity = Cquantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}
