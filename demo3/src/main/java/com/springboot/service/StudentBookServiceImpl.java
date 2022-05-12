package com.springboot.service;

import com.springboot.dao.StudentBookRepository;
import com.springboot.entity.StudentBookList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentBookServiceImpl implements StudentBookService{
    @Autowired
    StudentBookRepository studentBookRepository;



    @Override
    public List<StudentBookList> findAllByUserName(String userName) {
        return studentBookRepository.findAllByUserName(userName);
    }



    @Override
    public void save(StudentBookList theBook) {
        studentBookRepository.save(theBook);
    }



    @Override
    public void deleteById(int bookId) {
        studentBookRepository.deleteById(bookId);
    }



}