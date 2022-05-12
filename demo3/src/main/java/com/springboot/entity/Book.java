

package com.springboot.entity;


import org.springframework.stereotype.Component;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;



    @Column(name="name")
    @NotNull(message="cannot be null")
    @Pattern(regexp = "^(?=[a-zA-Z])[a-zA-Z0-9]{0,12}$",
            message = "name must be of 1 to 12 length with no special characters")
    private String name;

    @Column(name="author_name")
    @NotNull(message="cannot be null")
    @Pattern(regexp = "^(?=[a-zA-Z])[a-zA-Z0-9]{0,12}$",
            message = "author name must be of 1 to 12 length with no special characters")
    private String authorName;


    @Column(name="category")
    @NotNull(message="cannot be null")
    @Pattern(regexp = "^(?=[a-zA-Z])[a-zA-Z0-9]{0,12}$",
            message = "category must be of 1 to 12 length with no special characters")
    private String category;


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

    public String getAuthorName() {return authorName;}

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }





}