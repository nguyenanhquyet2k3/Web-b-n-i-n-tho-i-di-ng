package com.phone.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "money")
    private String money;
    @Column(name = "satus")
    private int status;
    @Column(name = "set_date")
    private Date setDate;
    @Column(name = "adress")
    private String adress;
    @Column(name = "note")
    private String note;

    @OneToMany(mappedBy = "orders")
    private Set<OrderDetails> listOrderDetails;

    public Set<OrderDetails> getListOrderDetails() {

        return listOrderDetails;
    }
    public void setListOrderDetails(Set<OrderDetails> listOrderDetails) {

        this.listOrderDetails = listOrderDetails;
    }
    public int getId() {

        return id;
    }
    public void setId(int id) {

        this.id = id;
    }
    public String getMoney() {

        return money;
    }
    public void setMoney(String money) {

        this.money = money;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {

        this.status = status;
    }
    public Date getSetDate() {
        return setDate;
    }
    public void setSetDate(Date setDate) {

        this.setDate = setDate;
    }
    public String getAdress() {

        return adress;
    }
    public void setAdress(String adress) {

        this.adress = adress;
    }
    public String getNote() {

        return note;
    }
    public void setNote(String note) {

        this.note = note;
    }
}

