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
        User user = new User();
        user.setStudentNumber("3");
        userRepository.delUser(user.getStudentNumber());

    }
    @Test
    void updateUser(){
        User user = new User();

        user.setStudentNumber("20170313015");
        user.setPhone("15778676033");
        user.setSex("男");
        user.setEmail("1648375651@qq.com");
        user.setCity("广西玉林");
        user.setUsername("靓仔");
        user.setClassify("程序员");
        user.setPassWord("0522");
        user.setSign("20");
        user.setWealth("620");
       userRepository.updateUser(user.getStudentNumber(),
               user.getUsername(),user.getPassWord()
               ,user.getEmail(),user.getPhone(),user.getCity(),
               user.getSign(),user.getClassify(),user.getWealth(),
               user.getSex());

    }

}
