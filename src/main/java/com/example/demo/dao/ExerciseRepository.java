package com.example.demo.dao;

import com.example.demo.model.Exercise;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface ExerciseRepository extends CrudRepository<Exercise,String>  {

    List<Exercise> findAll();
    List<Exercise> findBySid(String val);
    List<Exercise> findByTid(String val);

    @Transactional
    @Modifying
    @Query("update Exercise u set u.question = ?2, u.answer = ?3, u.item1 = ?4" +
            ", u.item2 = ?5, u.item3 = ?6, u.item4 = ?7, u.explains = ?8" +
            ", u.url = ?9 where u.tid = ?1")
    int updateExercise(String tid, String question , String  answer ,String item1,String item2 ,
                       String item3, String item4 , String explains, String url);

    @Transactional
    @Modifying
    @Query(value = "delete from Exercise where tid =?1")
    int deleteExercise(String tid);

}
