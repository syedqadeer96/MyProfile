package com.springboot.dao;

import com.springboot.entity.StudentBookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentBookRepository extends JpaRepository<StudentBookList,Integer>{
    List<StudentBookList> findAllByUserName(String userName);
}