package com.phone.entity;

import jakarta.persistence.*;

@Entity(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getNote() {

        return note;
    }

    public void setNote(String note) {

        this.note = note;
    }

    public User getUser() {

        return user;
    }

    public void setUser(User user) {

        this.user = user;
    }

    public Product getProduct() {

        return product;
    }

    public void setProduct(Product product) {

        this.product = product;
    }



}
