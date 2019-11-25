package com.example.demo.dao;

import com.example.demo.model.Exercise;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExerciseRepository extends CrudRepository<Exercise,String>  {

    List<Exercise> findAll();
    List<Exercise> findByTid(String val);

}
