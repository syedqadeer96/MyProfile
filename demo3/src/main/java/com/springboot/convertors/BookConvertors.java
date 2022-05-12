package com.springboot.convertors;

import com.springboot.dto.BookDto;
import com.springboot.entity.Book;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookConvertors {

    private final ModelMapper mapper = new ModelMapper();



    public Book dtoToEntity(BookDto bookDto){
        return mapper.map(bookDto,Book.class);
    }

    public BookDto entitytoDto(Book theBook){
        return mapper.map(theBook,BookDto.class);
    }


}




