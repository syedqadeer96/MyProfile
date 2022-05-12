package com.springboot.Repository;

import com.springboot.dao.BookRepository;
import com.springboot.entity.Book;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotNull;


@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class BookServiceTests {
    @Autowired
    private BookRepository repo;
    @Rule
    public final ExpectedException exception = ExpectedException.none();




    @Test
    public void testSaveBook1()
    {
        Book book=new Book();
        book.setName("BB");
        book.setAuthorName("aa");
        book.setCategory("cc");
        repo.save(book);
   Assertions.assertThat(book.getId()).isGreaterThan(0);
    }
   @Test
    public void testSaveBook2()
    {
        Book book=new Book();
        book.setName("BB");

        assertThatExceptionOfType(ConstraintViolationException.class)
                .isThrownBy( () -> {
                    repo.save(book);
                });

    }

    @Test
    public void testFindAll()
    {

        List<Book> books=  repo.findAll();
        assertNotNull(" books retrieved", books);


    }
    @Test
    public void testFindById()
    {
        Optional<Book> book=  repo.findById(1);
        assertEquals(" books retrieved", book.get().getId(), 1);


    }

    @Test
    public void testDeleteById1()
    {
        repo.deleteById(1);


    }
    @Test
    public void testDeleteById2()
    {


        assertThatExceptionOfType(EmptyResultDataAccessException.class)
                .isThrownBy( () -> {
                    repo.deleteById(-1);
                });

    }
@Test
    public void updateBookTest(){
    Book book=  repo.findById(1).get();
    book.setName("ff");

  Book bookUpdated=  repo.save(book);
  //  Assertions.assertThat(book.getId()).isEqualTo(bookUpdated);
    Assertions.assertThat(bookUpdated.getName()).isEqualTo("ff");
}


}