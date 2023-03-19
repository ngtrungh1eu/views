/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author ROG
 */
public class AccountsDTO {
    private int user_id;
    private String email;
    private String password;
    private String first_name;
    private String last_name;
    private LocalDate Dob;
//    private Date Dob;
    private String country;
    private String city;
    private String phone;
    private String gender;
    private String role;

    public AccountsDTO() {
    }

    public AccountsDTO(String email, String password, String first_name) {
        this.email = email;
        this.password = password;
        this.first_name = first_name;
    }

    public AccountsDTO(int user_id, String email, String password, String first_name, String last_name, LocalDate Dob, String country, String city, String phone, String gender, String role) {
        this.user_id = user_id;
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.Dob = Dob;
        this.country = country;
        this.city = city;
        this.phone = phone;
        this.gender = gender;
        this.role = role;
    }
   

    
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public LocalDate getDob() {
        return Dob;
    }

    public void setDob(LocalDate Dob) {
        this.Dob = Dob;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    

    
}
