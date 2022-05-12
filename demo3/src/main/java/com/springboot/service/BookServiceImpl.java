package com.springboot.service;

import com.springboot.convertors.BookConvertors;
import com.springboot.dao.BookRepository;
import com.springboot.dto.BookDto;
import com.springboot.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

@Autowired
    private BookRepository bookRepository;
/*
   @Autowired
    public BookServiceImpl(BookRepository theBookRepository) {
        this.bookRepository = theBookRepository;
    }*/

    @Autowired
    private BookConvertors bookConvertors;
    @Override
    public List<BookDto> findAll() {
        List<Book> books = bookRepository.findAll();
        List<BookDto> offersDTO = new ArrayList<BookDto>();
        for(Book book : books) {
            offersDTO.add(new BookConvertors().entitytoDto(book));
        }
        return offersDTO;
    }



    @Override
    public BookDto findById(int theId) {
        Optional<Book> result = bookRepository.findById(theId);

        Book theBook = null;

        if (result.isPresent()) {
            theBook = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find book id - " + theId);
        }

        return new BookConvertors().entitytoDto(theBook);
    }




  public BookDto save(BookDto bookDto) {
      Book theBook= bookConvertors.dtoToEntity(bookDto);
        bookRepository.save(theBook);
        BookDto booksDto = bookConvertors.entitytoDto(theBook);
        return  booksDto;
    }






    @Override
    public void deleteById(int theId) {

        bookRepository.deleteById(theId);
    }

}