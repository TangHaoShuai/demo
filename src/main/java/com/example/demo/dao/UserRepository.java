package com.example.demo.dao;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends CrudRepository<User,String> {
      List<User> findAll();
      int deleteByStudentNumber(User user);

      @Transactional
      @Modifying
      @Query("update User u set u.username = ?2, u.passWord = ?3, u.email = ?4 , u.phone = ?5 , u.city = ?6 , u.sign = ?7 , u.classify = ?8 , u.wealth = ?9 , u.sex = ?10 where u.studentNumber = ?1")
      int updateUser(String studentNumber, String username ,String passWord, String email ,String phone,String city, String sign ,String classify , String wealth ,String sex);

      @Transactional
      @Modifying
      @Query(value = "delete from User where studentNumber =?1")
      int delUser(String studentNumber);
}
