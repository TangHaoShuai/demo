package com.example.demo.controller;


import com.example.demo.dao.ExerciseRepository;
import com.example.demo.model.Exercise;
import com.example.demo.model.TestPaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/home")
public class ExerciseController {
    @Autowired
    private ExerciseRepository exerciseRepository;

    @ResponseBody
    @PostMapping("/AddExercise")
    public Map<String, String> AddTestpaper(Exercise exercise){
        Map<String, String> map = new HashMap<>();
        if(exercise.getQuestion() == "" || exercise.getTid() == "" || exercise.getAnswer() == "" || exercise.getItem1() == ""
        || exercise.getItem2() == "" || exercise.getItem3() == "" || exercise.getItem4() == "" || exercise.getExplains() == ""
        || exercise.getUrl() == "") {
            map.put("name","添加失败内容不能为空");
        }else {
            exerciseRepository.save(exercise);
            map.put("name","添加成功");
        }
        return map;
    }

    @ResponseBody
    @GetMapping("/ExerciseJson")
    public  Map<String,Object> TestPagerJson(String val){
        List<Exercise> exercises = exerciseRepository.findAll();
        if(val.length() > 0 ){
            List<Exercise> list = exerciseRepository.findBySid(val);
            exercises = list;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg",0);
        map.put("count", exercises.size());
        List<Object> list = new ArrayList<Object>();
        String[] str = new String[]{"id","sid","tid","question","answer","item1",
                "item2","item3","item4","explains","url"};
        for (int i = 0; i< exercises.size() ; i++){
            Map<String,Object> map1 = new HashMap<>();
            map1.put(str[0], exercises.get(i).getUid());
            map1.put(str[1], exercises.get(i).getSid());
            map1.put(str[2], exercises.get(i).getTid());
            map1.put(str[3], exercises.get(i).getQuestion());
            map1.put(str[4], exercises.get(i).getAnswer());
            map1.put(str[5], exercises.get(i).getItem1());
            map1.put(str[6], exercises.get(i).getItem2());
            map1.put(str[7], exercises.get(i).getItem3());
            map1.put(str[8], exercises.get(i).getItem4());
            map1.put(str[9], exercises.get(i).getExplains());
            map1.put(str[10], exercises.get(i).getUrl());
            list.add(map1);
        }
        map.put("data",list);
        return map;
    }


    @ResponseBody
    @PostMapping("/updateExercise")
    public  Map<String,String> TestPagerJson(Exercise exercise){
        Map<String, String> map = new HashMap<>();
        List<Exercise> exercises = exerciseRepository.findByTid(exercise.getTid());
        if(exercise.getQuestion() == "" || exercise.getTid() == "" || exercise.getAnswer() == "" || exercise.getItem1() == ""
                || exercise.getItem2() == "" || exercise.getItem3() == "" || exercise.getItem4() == "" || exercise.getExplains() == ""
                || exercise.getUrl() == "") {
            map.put("name","修改失败内容不能为空");
        }else if(exercises.size() >0 ){
            map.put("name","习题ID已经存在");
        }else{
            exerciseRepository.updateExercise(exercise.getTid(),exercise.getQuestion(),exercise.getAnswer(),
                    exercise.getItem1(),exercise.getItem2(),exercise.getItem3(),exercise.getItem4(),
                    exercise.getExplains(),exercise.getUrl());
            map.put("name","修改修改成功");
        }
        return map;
    }

    @ResponseBody
    @PostMapping("deleteExercise")
    public Map<String,String> deleteExercise(Exercise exercise){
        Map<String, String> map = new HashMap<>();
        if (exercise.getTid() == ""){
            map.put("name","编号不可以为空");
        }else{
            exerciseRepository.deleteExercise(exercise.getTid());
            map.put("name","删除成功");
        }
        return map;
    }




}
