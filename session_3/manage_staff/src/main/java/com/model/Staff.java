package com.model;

public class Staff {
    private int id ;
    private String name ;
    private int age;
    private double salary;
    private String image;
    private Brand brand;
    private int idBrand;

    public Staff() {
    }

    public Staff(int id, String name, int age, double salary, String image ,Brand brand) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.image = image;
        this.brand = brand;
    }

    public Staff( String name, int age, double salary, int idBrand) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.idBrand = idBrand;
    }
    public Staff( String name, int age, double salary , String image , int idBrand) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.image = image;
        this.idBrand = idBrand;
    }

    public Staff(int id , String name, int age, double salary, int idBrand) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.idBrand = idBrand;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(int idBrand) {
        this.idBrand = idBrand;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
