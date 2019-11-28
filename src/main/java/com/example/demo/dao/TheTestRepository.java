package com.example.demo.dao;

import com.example.demo.model.TestPaper;
import com.example.demo.model.TheTest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TheTestRepository extends CrudRepository<TheTest,String> {

    List<TheTest> findAll();
}
