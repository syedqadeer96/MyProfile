package com.springboot.entity;





import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name = "users")
public class User {


@Id
@Column(name = "username")

private String username;



    @Column(name = "password")
    private String password;

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private int enabled;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
