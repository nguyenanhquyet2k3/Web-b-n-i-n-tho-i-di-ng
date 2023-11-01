package com.phone.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name_cate")
    private String nameCate;
    @Column(name = "status")
    private int status;

    @OneToMany(mappedBy = "category")
    private Set<Product> listProduct;

    public Set<Product> getListProduct() {

        return listProduct;
    }
    public void setListProduct(Set<Product> listProduct) {

        this.listProduct = listProduct;
    }
    public int getId() {

        return id;
    }
    public void setId(int id) {

        this.id = id;
    }
    public String getNameCate() {

        return nameCate;
    }
    public void setNameCate(String nameCate) {

        this.nameCate = nameCate;
    }
    public int getStatus() {

        return status;
    }
    public void setStatus(int status) {

        this.status = status;
    }

}
