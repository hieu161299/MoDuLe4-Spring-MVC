package com.blog.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Không được để trống")
    private String name;

    @NotEmpty(message = "Không được để trống")
    @Column(columnDefinition = "TEXT")
    private String content;
    @NotEmpty(message = "Không được để trống")
    @Column(columnDefinition = "TEXT")
    private String image;

    @ManyToOne
    private Category category;

    public News() {
    }

    public News(int id, String name, String content, String image, Category category) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.image = image;
        this.category = category;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
