package com.example.demo.dao;

import com.example.demo.model.Exercise;
import com.example.demo.model.TestPaper;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface TestPagerRepository extends CrudRepository<TestPaper,String> {

    List<TestPaper> findAll();

    List<TestPaper> findByTid(String val);

//    @Transactional
//    @Modifying
//    @Query("update TestPaper u set u.tname = ?2, u.introduce = ?3 where u.tid = ?1")
//    int updateTestPaper(String tid, String username , String  introduce);
//
//    @Transactional
//    @Modifying
//    @Query(value = "delete from TestPaper where studentNumber =?1")
//    int delTestPaper(String tid);

}
