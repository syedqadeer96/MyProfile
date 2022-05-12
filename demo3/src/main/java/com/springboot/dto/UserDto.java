package com.springboot.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Component
@Data
public class UserDto {
    @Column(name="username")
    private String username;




    @Column(name="password")
    private String password;

    private int enabled;
}
