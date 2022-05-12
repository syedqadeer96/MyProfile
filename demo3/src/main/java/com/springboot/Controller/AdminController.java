package com.springboot.Controller;

import com.springboot.dto.BookDto;
import com.springboot.entity.Book;
import com.springboot.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String getBooks(Model theModel) {

        List<BookDto> books=bookService.findAll();
        theModel.addAttribute("books",books);
        logger.info("Operation  get the book list");

        return "listBooks";

    }

    @GetMapping("/addBook")
    public String addNewBook(Model model) {
        model.addAttribute("book"   , new Book());
        logger.info("Operation get  Book");
        return "addBook";
    }


/*    @RequestMapping("/saveCustomer")
    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult bindingResult) {


        System.out.println("Binding Result : "+bindingResult);

        if (bindingResult.hasErrors()) {
            return "customer-form";
        } else {

            // save the customer using our service
            customerService.saveCustomer(theCustomer);


            return "redirect:/customer/list";
        }
    }*/




    @PostMapping("/books")
    public String addBook(@Valid @ModelAttribute("book") BookDto booksDto, BindingResult bindingResult) {

      //  logger.error("error in adding book::" + bindingResult);

   //     if (bindingResult.hasErrors()) {
     //       return "addBook";


        if (bindingResult.hasErrors()) {
            logger.error("error in adding book"+bindingResult.hasErrors());
            return "addBook";




        } else {
            bookService.save(booksDto);
            logger.info("Operation Added New Book");
            return "redirect:/admin/books";

        }
    }




    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id") int theId,
                                    Model theModel) {

        BookDto theBook = bookService.findById(theId);
        logger.info("Operation show form update");
        theModel.addAttribute("book", theBook);
        return "addBook";
    }



    @GetMapping("/books/{bookId}")
    public String deleteBook(@PathVariable int bookId) {
        bookService.deleteById(bookId);
        logger.info("Operation get book with defined id");
        return "redirect:/admin/books";
    }

}