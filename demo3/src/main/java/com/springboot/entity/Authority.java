package com.springboot.entity;

import lombok.Builder;
import lombok.Data;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
@Data
public class Authority {



    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "authority")
    @Value("${ROLE:ROLE_STUDENT}")
    private String authority;


}

