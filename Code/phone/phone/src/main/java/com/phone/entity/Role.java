package com.phone.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_role")
    private String nameRole;

    @JsonIgnore
    @OneToMany(mappedBy = "role")
    private Set<User> listUser;


    public Set<User> getListUser() {

        return listUser;
    }

    public void setListUser(Set<User> listUser) {

        this.listUser = listUser;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getNameRole() {

        return nameRole;
    }

    public void setNameRole(String nameRole) {

        this.nameRole = nameRole;
    }


}

