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

}
