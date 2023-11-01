package com.phone.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "fullname")
    private String fullName;
    @Column(name = "username")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Feedback> listFeedback;

    public Set<Feedback> getListFeedback() {

        return listFeedback;
    }

    public void setListFeedback(Set<Feedback> listFeedback) {

        this.listFeedback = listFeedback;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getFullName() {

        return fullName;
    }

    public void setFullName(String fullName) {

        this.fullName = fullName;
    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public Role getRole() {

        return role;
    }

    public void setRole(Role role) {

        this.role = role;
    }


}

