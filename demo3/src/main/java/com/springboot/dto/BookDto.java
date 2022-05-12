package com.springboot.dto;

import org.springframework.stereotype.Component;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Component
@Data
public class BookDto

{


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

}
