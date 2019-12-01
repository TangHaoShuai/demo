package com.example.demo.dao;

import com.example.demo.model.TestPaper;
import com.example.demo.model.TheTest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface TheTestRepository extends CrudRepository<TheTest,String> {

    List<TheTest> findAll();
    List<TheTest> findByTheName(String val);

    @Transactional
    @Modifying
    @Query(value = "delete from TheTest where uid =?1")
    int deleteTheTest(String tid);

    @Transactional
    @Modifying
    @Query("update TheTest u set u.theName = ?2, u.theStartTime = ?3, u.theEndOfTime = ?4" +
            ", u.TestPaperID = ?5, u.State = ?6 where u.uid = ?1")
    int updateTheTest(String tid, String theName , String  theStartTime ,String theEndOfTime,
                      String TestPaperID ,
                       String State);

}
