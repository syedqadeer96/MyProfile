package com.springboot.Controller;


import com.springboot.dto.BookDto;
import com.springboot.entity.Authority;
import com.springboot.entity.Book;
import com.springboot.entity.User;
import com.springboot.service.BookService;
import com.springboot.service.UserService;
import org.jetbrains.annotations.NotNull;
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
@RequestMapping("/new")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping("/addStu")
    public String addNewStu(Model model) {
        model.addAttribute("users", new User());
        logger.info("Operation get student  ");
        return "addStudent";
    }

    @PostMapping("/saveStudent")
       public String saveCustomer(@ModelAttribute("user") User theUser) {
   theUser.setEnabled(1);
   Authority authority=new Authority();
   authority.setUsername(theUser.getUsername());
   authority.setAuthority("ROLE_STUDENT");
           // save the customer using our service
         logger.info("Operation adding new student  ");
         userService.save(theUser,authority);


           return "redirect:/login";
       }
 /*   @PostMapping("/saveStudent")
    public String saveCustomer(@Valid @ModelAttribute("user") User theUser, BindingResult bindingResult) {


        if (bindingResult.hasErrors()) {
            logger.error("error in adding student" + bindingResult.hasErrors());
            return "addStudent";


        } else {

            theUser.setEnabled(1);
            Authority authority = new Authority();
            authority.setUsername(theUser.getUsername());
            authority.setAuthority("ROLE_STUDENT");
            // save the customer using our service
            logger.info("Operation adding new student  ");
            userService.save(theUser, authority);


            return "redirect:/login";
        }*/


    }
