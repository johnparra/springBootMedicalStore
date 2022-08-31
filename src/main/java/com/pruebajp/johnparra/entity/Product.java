package com.pruebajp.johnparra.entity;

import javax.persistence.*;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_product", nullable = false, unique = true)
    private Long id;
    @Column(name="name", length = 255)
    private String name;
    @Column(name="price")
    private int price;
    @Column(name="stockQuantity")
    private int stockQuantity;
    @Column(name="minimalQuantityAsk")
    private int minimalQuantityAsk;

    @ManyToOne
    private ProductOrder productOrder;

    public Product() {
    }

    public Product(String name, int price, int stockQuantity, int minimalQuantityAsk) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.minimalQuantityAsk = minimalQuantityAsk;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                ", minimalQuantityAsk=" + minimalQuantityAsk +
                ", productOrder=" + productOrder +
                '}';
    }

    public ProductOrder getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(ProductOrder productOrder) {
        this.productOrder = productOrder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public int getMinimalQuantityAsk() {
        return minimalQuantityAsk;
    }

    public void setMinimalQuantityAsk(int minimalQuantityAsk) {
        this.minimalQuantityAsk = minimalQuantityAsk;
    }

}
