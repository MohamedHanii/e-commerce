package com.example.ecommerce.product.model.entity;

import com.example.ecommerce.user.model.entity.User;
import jakarta.persistence.*;

@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name="title")
    private String productTitle;
    @Column(name="description")
    private String description;
    @Column(name="category")
    private String category;
    @Column(name="brand")
    private String brand;
    @Column(name="price")
    private double price;
    @Column(name="stock_quantity")
    private int stockQuantity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product(String productTitle, String description, String category, String brand, double price, int stockQuantity) {
        this.productTitle = productTitle;
        this.description = description;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public Product(int id, String productTitle, String description, String category, String brand, double price, int stockQuantity) {
        this.id = id;
        this.productTitle = productTitle;
        this.description = description;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productTitle='" + productTitle + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                '}';
    }
}


