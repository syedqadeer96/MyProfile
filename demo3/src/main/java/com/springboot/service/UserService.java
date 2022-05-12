package com.springboot.service;
import com.springboot.entity.Authority;
import com.springboot.entity.User;

public interface UserService {

    public void save(User theUser, Authority authority);
}

