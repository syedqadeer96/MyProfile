package com.springboot.service;

import com.springboot.entity.StudentBookList;

import java.util.List;

public interface StudentBookService {

    List<StudentBookList> findAllByUserName(String username);
    public void save(StudentBookList theBook);
    public void deleteById(int theId);
}