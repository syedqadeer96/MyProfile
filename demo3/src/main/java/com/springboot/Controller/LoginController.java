package com.springboot.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);



    @RequestMapping("/login")
    public String login()
    {
        return "login";


    }

    @RequestMapping("/success")
    public void loginPageRedirect(HttpServletRequest request, HttpServletResponse response, Authentication authResult) throws IOException, ServletException {

        String role =  authResult.getAuthorities().toString();

        if(role.contains("ROLE_ADMIN")){
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/admin/books"));
            logger.info("User is ADMIN");

        }
        else if(role.contains("ROLE_STUDENT")) {
            logger.info("User is student");

            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/student/books"));

        }
    }
    @GetMapping("/access-denied")
    public String renderAccessDeniedPage() {
        logger.info("Operation  access is denied");

        return "accessDenied";
    }

}
