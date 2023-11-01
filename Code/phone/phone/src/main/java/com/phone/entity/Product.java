package com.phone.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name_product")
    private String nameProduct;
    @Column(name = "image")
    private String image;
    @Column(name = "information")
    private String information;
    @Column(name = "price")
    private Double price;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "update_at")
    private Date updateAt;
    @Column(name = "status")
    private int status;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private Set<Picture> listPicture;

    @OneToMany(mappedBy = "product")
    private Set<Feedback> listFeedback;

    @OneToMany(mappedBy = "product")
    private Set<OrderDetails> listOrderDetails;

    public Set<OrderDetails> getListOrderDetails() {

        return listOrderDetails;
    }

    public void setListOrderDetails(Set<OrderDetails> listOrderDetails) {
        this.listOrderDetails = listOrderDetails;
    }

    public Set<Feedback> getListFeedback() {

        return listFeedback;
    }

    public void setListFeedback(Set<Feedback> listFeedback) {

        this.listFeedback = listFeedback;
    }

    public Set<Picture> getListPicture() {

        return listPicture;
    }

    public void setListPicture(Set<Picture> listPicture) {

        this.listPicture = listPicture;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getNameProduct() {

        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {

        this.nameProduct = nameProduct;
    }

    public String getImage() {

        return image;
    }

    public void setImage(String image) {

        this.image = image;
    }

    public String getInformation() {

        return information;
    }

    public void setInformation(String information) {

        this.information = information;
    }

    public Double getPrice() {

        return price;
    }

    public void setPrice(Double price) {

        this.price = price;
    }

    public Date getCreatedAt() {

        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {

        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {

        this.updateAt = updateAt;
    }

    public int getStatus() {

        return status;
    }

    public void setStatus(int status) {

        this.status = status;
    }

    public Category getCategory() {

        return category;
    }

    public void setCategory(Category category) {

        this.category = category;
    }

}

