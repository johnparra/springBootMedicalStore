package com.pruebajp.johnparra.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_order", nullable = false, unique = true)
    private Long id;
    @Column(name="id_customer", nullable = false)
    private Long idCustomer;
    private LocalDate sellDate;
    @OneToOne
    private Customer customer;
    @OneToMany(mappedBy = "product_order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<ProductOrder> productOrderList = new ArrayList<>();

    public Order() {
    }

    public Order(Long idCustomer, LocalDate sellDate) {
        this.idCustomer = idCustomer;
        this.sellDate = sellDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", idCustomer=" + idCustomer +
                ", sellDate=" + sellDate +
                ", customer=" + customer +
                ", productOrderList=" + productOrderList +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public LocalDate getSellDate() {
        return sellDate;
    }

    public void setSellDate(LocalDate sellDate) {
        this.sellDate = sellDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<ProductOrder> getProductOrderList() {
        return productOrderList;
    }

    public void setProductOrderList(List<ProductOrder> productOrderList) {
        this.productOrderList = productOrderList;
    }

}
