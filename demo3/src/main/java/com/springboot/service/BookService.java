package com.springboot.service;


import com.springboot.dto.BookDto;
import com.springboot.entity.Book;

import java.util.List;

public interface BookService {
    public List<BookDto> findAll();

    public BookDto findById(int theId);

    public BookDto save(BookDto bookDto);




    public void deleteById(int theId);
}