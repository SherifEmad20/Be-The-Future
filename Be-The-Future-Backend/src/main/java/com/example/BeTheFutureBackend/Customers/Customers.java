package com.example.BeTheFutureBackend.Customers;

import com.example.BeTheFutureBackend.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Customers")
public class Customers {

    @Id
    private String customerName;
    private String customerFullName;
    private String customerEmail;
    private String customerPassword;
    private String customerPhoneNum;
    private String customerAddress;
    private String customerCity;
    private String customerPhoto;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Customers() {

    }

    public Customers(String customerName, String customerEmail, String customerPassword, String customerPhoneNum,
                     String customerAddress, String customerCity, String customerPhoto) {
        this.customerName = customerName;
        this.customerFullName = customerName;
        this.customerEmail = customerEmail;
        this.customerPassword = customerPassword;
        this.customerPhoneNum = customerPhoneNum;
        this.customerAddress = customerAddress;
        this.customerCity = customerCity;
        this.customerPhoto = customerPhoto;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getCustomerPhoneNum() {
        return customerPhoneNum;
    }

    public void setCustomerPhoneNum(String customerPhoneNum) {
        this.customerPhoneNum = customerPhoneNum;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerPhoto() {
        return customerPhoto;
    }

    public void setCustomerPhoto(String customerPhoto) {
        this.customerPhoto = customerPhoto;
    }

    //add product to customer
    public void addProduct(Product product) {
        productList.add(product);
        product.setCustomer(this);
    }
}
