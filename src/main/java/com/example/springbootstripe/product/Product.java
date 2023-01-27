package com.example.springbootstripe.product;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    private String description;
    @Column(nullable = false)
    private Long price;
    @Column(nullable = false)
    private Integer productId;
    @Column(nullable = false)
    private Integer stock;

    public Product() {
    }

    public Product(String name, Long price, Integer productId, Integer stock) {
        this.name = name;
        this.price = price;
        this.productId = productId;
        this.stock = stock;
    }

    public Product(String name, String description, Long price, Integer productId, Integer stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.productId = productId;
        this.stock = stock;
    }

    public Product(Integer id, String name, String description, Long price, Integer productId, Integer stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.productId = productId;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(price, product.price) && Objects.equals(productId, product.productId) && Objects.equals(stock, product.stock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, productId, stock);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", productId=" + productId +
                ", stock=" + stock +
                '}';
    }
}
