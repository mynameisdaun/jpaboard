package com.example.jpaboard.domain.repository;

import com.example.jpaboard.domain.entity.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired UserRepository userRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    public void createUser() throws Exception {
        //given
        String email = "daun";
        String password = "1234";
        Users user = Users.createUser(email, password);

        //when
        Long id = userRepository.save(user);

        //then
        Users findUser = userRepository.find(id);

        assertEquals(findUser, user);
    }

}