package org.raghav.mycrudapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.raghav.mycrudapp.Models.User;
import org.raghav.mycrudapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {
    @Autowired private UserRepository userRepository;

    @Test
    public void AddNewTest(){
        User user = new User();
        user.setFirstName("xyz");
        user.setLastName("rst");
        user.setEmailId("uvw.lmn@java.com");
        user.setPassword("password456");
        long number = 987654123;
        user.setPhoneNumber(number);
        user.setIsEnabled(true);

        User SavedUser = userRepository.save(user);

        assertNotNull(SavedUser);
    }
 }
