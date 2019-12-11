package com.example.demo.dao;

import com.example.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends CrudRepository<User,String> {
      List<User> findAll();
      int deleteByStudentNumber(User user);

      List<User> findByStudentNumber(String StudentNumber);

      Page<User> findAll(Pageable pageable);

   //   Page<User> findUserByStudentNumber(Pageable pageable);

      @Transactional
      @Modifying
      @Query("update User u set u.username = ?2, u.passWord = ?3, u.email = ?4 , u.phone = ?5 , u.city = ?6 , u.sign = ?7 , u.classify = ?8 , u.wealth = ?9 , u.sex = ?10 where u.studentNumber = ?1")
      int updateUser(String studentNumber, String username ,String passWord, String email ,String phone,String city, String sign ,String classify , String wealth ,String sex);

      @Transactional
      @Modifying
      @Query(value = "delete from User where studentNumber =?1")
      int delUser(String studentNumber);



      @Query(nativeQuery = true, value = "SELECT * FROM user ORDER BY :urderkey   limit :startrow, :sizesss ; ")
      List<User> findUsers(@Param("urderkey") String urderkey, @Param("startrow") Integer startrow,@Param("sizesss") Integer sizesss);

      @Query(nativeQuery = true, value = "SELECT * FROM user where student_number = :student_number  ORDER BY :urderkey    limit :startrow, :sizesss ; ")
      List<User> findUserstudentNumber(@Param("student_number") String studentNumber,@Param("urderkey") String urderkey, @Param("startrow") Integer startrow,@Param("sizesss") Integer sizesss);
}
