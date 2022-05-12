package com.springboot.Controller;


import com.springboot.dto.BookDto;
import com.springboot.entity.StudentBookList;
import com.springboot.service.BookService;
import com.springboot.service.StudentBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentBookService studentBookService;
    @Autowired
    private BookService bookService;


    private String getUserName()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return currentPrincipalName;
    }

    @GetMapping("/books")
    public String getBooks(Model theModel)
    {  String currentPrincipalName=getUserName();
        List<StudentBookList> books=studentBookService.findAllByUserName(currentPrincipalName);
        theModel.addAttribute("books",books);
        logger.info("operation get list of books");

        return "studentBookList";

    }

    @GetMapping("/books/{bookId}")
    public String removeBook(@PathVariable int bookId)
    {
        studentBookService.deleteById(bookId);
        logger.info("operation delete book by id");

        return "redirect:/student/books";

    }

    @GetMapping("/showList")
    public String showBookList(Model theModel)
    {String currentPrincipalName=getUserName();
        List<BookDto> result=bookService.findAll();

        List<String> alreadyAddedBooks=new ArrayList<String>();
        List<StudentBookList>bookList=studentBookService.findAllByUserName(currentPrincipalName);

        for(StudentBookList b : bookList)
        {alreadyAddedBooks.add(b.getName());}

        List<BookDto> books=new ArrayList<>();
        for(int i=0;i<result.size();i++)
        {
            if(alreadyAddedBooks.contains(result.get(i).getName()))
            {}
            else
            {books.add(result.get(i));}

        }

        theModel.addAttribute("books",books);
        logger.info("operation show book list");

        return "listBooks";

    }
    @GetMapping("/add")
    public String addBooks(@RequestParam("id") int theId)
    {
        String currentPrincipalName=getUserName();
        BookDto book= bookService.findById(theId);

        StudentBookList bookList=new StudentBookList();

        bookList.setUserName(currentPrincipalName);
        bookList.setAuthorName(book.getAuthorName());
        bookList.setCategory(book.getCategory());
        bookList.setName(book.getName());
        studentBookService.save(bookList);
        logger.info("operation add books for student");

        return "redirect:/student/showList";

    }


}