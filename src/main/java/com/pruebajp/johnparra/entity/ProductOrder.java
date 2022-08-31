package com.pruebajp.johnparra.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="product_order")
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_product_order", nullable = false, unique = true)
    private Long id;
    @Column(name="id_product", nullable = false)
    private Long idProduct;
    @Column(name="id_order", nullable = false)
    private Long idOrder;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Product> productList = new ArrayList<>();

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Order order;

    public ProductOrder() {
    }

    public ProductOrder(Long idProduct, Long idOrder) {
        this.idProduct = idProduct;
        this.idOrder = idOrder;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "ProductOrder{" +
                "id=" + id +
                ", idProduct=" + idProduct +
                ", idOrder=" + idOrder +
                ", productList=" + productList +
                ", order=" + order +
                '}';
    }
}
