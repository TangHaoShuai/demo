package com.example.demo;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {
        User user = new User();

        user.setPassWord("123");
        user.setPhone("15778676033");
        user.setSex("女");
        userRepository.save(user);
    }
    @Test
    void inquire(){
       List<User> users = new ArrayList<>();

      users = userRepository.findAll();
        System.out.printf(users.toString());
    }

}
