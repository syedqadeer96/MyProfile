package com.springboot.Repository;


    import com.springboot.dao.StudentBookRepository;
    import com.springboot.entity.Book;
import com.springboot.entity.StudentBookList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotNull;

    @DataJpaTest
    @AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
    public class StudentBookServiceTests {

        @Autowired
        private StudentBookRepository repo;

        @Test
        public void testFindAllByUserName() {

            List<StudentBookList> sb = repo.findAllByUserName("john");
            assertEquals(" ", 0, sb.size());

        }

        @Test
        public void testsaveEntryInBookList() {
            StudentBookList entry = new StudentBookList();
            entry.setName("bb");
            entry.setCategory("cc");
            entry.setAuthorName("aa");
            entry.setUserName("john");
            repo.save(entry);


        }


    }