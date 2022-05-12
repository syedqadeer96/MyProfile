package com.springboot.Repository;

import com.springboot.Controller.AdminController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdminControllerTest {

    @Test
    @DisplayName("Test should pass when name is of 1 to 12 length with no special characters")
    void addBookWithNoSpecialCharacters() {
        AdminController adminController=new AdminController();
    }
}