package com.example.demo.dao;

import com.example.demo.model.TestPaper;
import com.example.demo.model.TheTest;
import org.springframework.data.repository.CrudRepository;

public interface TheTestRepository extends CrudRepository<TheTest,String> {

}
