package com.example.demo;

import com.example.demo.dao.ExerciseRepository;
import com.example.demo.dao.TestPagerRepository;
import com.example.demo.dao.TheTestRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.model.Exercise;
import com.example.demo.model.TestPaper;
import com.example.demo.model.TheTest;
import com.example.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ExerciseRepository exerciseRepository;
    @Autowired
    private TestPagerRepository testPagerRepository;
    @Autowired
    private TheTestRepository theTestRepository;

    @Test
    void contextLoads() {
//        User user = new User();
//        user.setPassWord("123");
//        user.setPhone("15778676033");
//        user.setSex("女");
//        userRepository.save(user);
      List<User> users = userRepository.findByStudentNumber("2015456");
      System.out.printf(users.toString());
    }
    @Test
    void inquire(){
        User user = new User();
        user.setStudentNumber("3");
        userRepository.delUser(user.getStudentNumber());

    }
    @Test
    void updateUser(){

        for (int i=0; i<=10 ;i++){
            User user = new User();
            user.setStudentNumber("2017031301"+i);
            user.setPhone("15778676033");
            user.setSex("男");
            user.setEmail("1648375651@qq.com");
            user.setCity("广西玉林");
            user.setUsername("靓仔");
            user.setClassify("程序员");
            user.setPassWord("0522");
            user.setSign("20");
            user.setWealth("620");
//       userRepository.updateUser(user.getStudentNumber(),
//               user.getUsername(),user.getPassWord()
//               ,user.getEmail(),user.getPhone(),user.getCity(),
//               user.getSign(),user.getClassify(),user.getWealth(),
//               user.getSex());
            userRepository.save(user);
        }


    }

    @Test
    void  AddTestPageaasd(){
        Exercise exercise = new Exercise();
        exercise.setQuestion("这个一个测试！！！！");
        exercise.setAnswer("1");
        exercise.setItem1("答案A");
        exercise.setItem2("答案B");
        exercise.setItem3("答案C");
        exercise.setItem4("答案D");
        exercise.setExplains("因为这是一个测试！没有对错");
        exercise.setUrl("hemo/img");
        exercise.setTid("50");
        exerciseRepository.save(exercise);

    }
    @Test
    void  AddTestPagesdsad(){
        TestPaper testPaper = new TestPaper();
        testPaper.setTid("232");
        testPaper.setTname("android开发");
        testPaper.setIntroduce("这是测试！！！！！！");
        testPagerRepository.save(testPaper);

    }

    @Test
    void  TheTest22(){
        TheTest theTest = new TheTest();
            theTest.setTheName("android测试");
            theTest.setTestPaperID("004");
            theTest.setTheStartTime("2019.11.28 8:30");
            theTest.setTheEndOfTime("2019.11.29 8:30");
            theTest.setState("正在进行");
            theTestRepository.save(theTest);
    }
    @Test
    void  asdfasdfa(){
        Pageable pageable =  PageRequest.of(1,5);
      Page<User> users = userRepository.findAll(pageable);
      for (User u:users ){
          System.out.println(u.getStudentNumber());
      }
    }




}
