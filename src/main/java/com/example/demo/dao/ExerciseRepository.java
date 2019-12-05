package com.example.demo.dao;

import com.example.demo.model.Exercise;
import com.example.demo.model.TestPaper;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

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

    @Query(nativeQuery = true, value = "SELECT * FROM exercise ORDER BY :urderkey   limit :startrow, :sizesss ; ")
    List<Exercise> findExercises(@Param("urderkey") String urderkey, @Param("startrow") Integer startrow, @Param("sizesss") Integer sizesss);

    @Query(nativeQuery = true, value = "SELECT * FROM exercise where tid = :tid  ORDER BY :urderkey    limit :startrow, :sizesss ; ")
    List<Exercise> findExerciseByTid(@Param("tid") String tid,@Param("urderkey") String urderkey, @Param("startrow") Integer startrow,@Param("sizesss") Integer sizesss);

    @Query(nativeQuery = true, value = "SELECT * FROM exercise where sid = :sid  ORDER BY :urderkey    limit :startrow, :sizesss ; ")
    List<Exercise> findExerciseBySid(@Param("sid") String sid,@Param("urderkey") String urderkey, @Param("startrow") Integer startrow,@Param("sizesss") Integer sizesss);

}
