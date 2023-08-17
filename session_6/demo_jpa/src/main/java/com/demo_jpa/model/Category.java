package com.demo_jpa.model;

import javax.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategory;
    private String nameCategory;

    public Category() {
    }

    public Category(int id, String name) {
        this.idCategory = id;
        this.nameCategory = name;
    }

    public int getId() {
        return idCategory;
    }

    public void setId(int id) {
        this.idCategory = id;
    }

    public String getName() {
        return nameCategory;
    }

    public void setName(String name) {
        this.nameCategory = name;
    }
}
