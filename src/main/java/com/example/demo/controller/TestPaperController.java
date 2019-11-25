package com.example.demo.controller;


import com.example.demo.dao.TestPagerRepository;
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
@RequestMapping("home")
public class TestPaperController {

    @Autowired
    private TestPagerRepository testPagerRepository;

    @ResponseBody
    @GetMapping("/TestPaperJson")
        public Map<String,Object> TestPaperJson(String val) {
        List<TestPaper> testPapers = testPagerRepository.findAll();
        if(val.length() > 0 ){
            List<TestPaper> list = testPagerRepository.findByTid(val);
            testPapers = list;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg",0);
        map.put("count", testPapers.size());
        List<Object> list = new ArrayList<Object>();
        String[] str = new String[]{"id","tid","tname","introduce"};
        for (int i = 0; i< testPapers.size() ; i++){
            Map<String,Object> map1 = new HashMap<>();
            map1.put(str[0], testPapers.get(i).getUid());
            map1.put(str[1], testPapers.get(i).getTid());
            map1.put(str[2], testPapers.get(i).getTname());
            map1.put(str[3], testPapers.get(i).getIntroduce());
            list.add(map1);
        }
        map.put("data",list);
        return map;
    }

    @ResponseBody
    @PostMapping("/AddTestPager")
    public Map<String,String> AddTestPager(TestPaper testPaper){
        Map<String, String> map = new HashMap<>();
        if(testPaper.getTid() =="" || testPaper.getTname() =="" ||
        testPaper.getIntroduce()==""){
            map.put("name","添加失败内容不能为空");
        }else{
            testPagerRepository.save(testPaper);
            map.put("name","添加成功");
        }
        return  map;
    }
    @ResponseBody
    @PostMapping("updateTestPager")
    public Map<String,String> updateTestPager(TestPaper testPaper){
        Map<String, String> map = new HashMap<>();
        if(testPaper.getTid() =="" || testPaper.getTname() =="" ||
                testPaper.getIntroduce()==""){
            map.put("name","修改失败内容不能为空");
        }else{
            testPagerRepository.updateTestPaper(
            testPaper.getTid(),testPaper.getTname(),
                    testPaper.getIntroduce());
            map.put("name","修改成功");
        }
        return  map;
    }
    @ResponseBody
    @PostMapping("deleteTestPager")
    public Map<String,String> deleteTestPager(TestPaper testPaper){
        Map<String, String> map = new HashMap<>();
        if (testPaper.getTid() == ""){
            map.put("name","编号不可以为空");
        }else{
            testPagerRepository.deleteTestPager(testPaper.getTid());
            map.put("name","删除成功");
        }
        return map;
    }


}
