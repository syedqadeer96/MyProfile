package com.springboot.service;

import com.springboot.dao.AuthorityRepository;
import com.springboot.dao.UserRepository;
import com.springboot.entity.Authority;
import com.springboot.entity.StudentBookList;
import com.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthorityRepository authorityRepository;


    @Override
    public void save(User theUser, Authority authority) {
        userRepository.save(theUser);
        authorityRepository.save(authority);
    }
}
