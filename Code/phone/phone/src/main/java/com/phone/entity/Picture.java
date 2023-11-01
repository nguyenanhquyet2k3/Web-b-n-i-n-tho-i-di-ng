package com.phone.entity;

import jakarta.persistence.*;

@Entity(name = "picture")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "img")
    private String img;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    public int getId() {

        return id;
    }
    public void setId(int id) {

        this.id = id;
    }
    public String getImg() {

        return img;
    }
    public void setImg(String img) {

        this.img = img;
    }
    public Product getProduct() {

        return product;
    }
    public void setProduct(Product product) {

        this.product = product;
    }

}
