package com.phone.entity;

import jakarta.persistence.*;

@Entity(name = "order_details")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "quantity")
    private String quantity;
    @Column(name = "total_payment")
    private String totalPayment;

    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getQuantity() {

        return quantity;
    }

    public void setQuantity(String quantity) {

        this.quantity = quantity;
    }

    public String getTotalPayment() {

        return totalPayment;
    }

    public void setTotalPayment(String totalPayment) {

        this.totalPayment = totalPayment;
    }

    public Orders getOrders() {

        return orders;
    }

    public void setOrders(Orders orders) {

        this.orders = orders;
    }

    public Product getProduct() {

        return product;
    }

    public void setProduct(Product product) {

        this.product = product;
    }
}
