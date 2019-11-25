package com.example.demo.controller;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;
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
public class home {
    @Autowired
    private  UserRepository userRepository;

    @ResponseBody
    @GetMapping("/userjson")
    public  Map<String,Object> userJosn(String val){
        List<User> users = userRepository.findAll();
        if(val.length() >0 ){
            List<User> list = userRepository.findByStudentNumber(val);
            users = list;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg",0);
        map.put("count",users.size());
        List<Object> list = new ArrayList<Object>();

        String[] str = new String[]{"id","studentNumber","phone","username",
        "email","sex","city","sign","classify","wealth"};
        for (int i=0 ; i< users.size() ; i++ ){
                 Map<String,Object> map1 = new HashMap<>();
                 map1.put(str[0],users.get(i).getUid());
                 map1.put(str[1],users.get(i).getStudentNumber());
                 map1.put(str[2],users.get(i).getPhone());
                 map1.put(str[3],users.get(i).getUsername());
                 map1.put(str[4],users.get(i).getEmail());
                 map1.put(str[5],users.get(i).getSex());
                 map1.put(str[6],users.get(i).getCity());
                 map1.put(str[7],users.get(i).getSign());
                 map1.put(str[8],users.get(i).getClassify());
                 map1.put(str[9],users.get(i).getWealth());
                 list.add(map1);
        }
        //  map1.clear();  清除map数据
        map.put("data",list);
        return map;
    }

    @PostMapping("/AddUser")
    @ResponseBody
    public  Map<String, String> test(User user){
        Map<String, String> map = new HashMap<>();
        if (user.getStudentNumber() == "" || user.getUsername() == "" || user.getPassWord() == "" || user.getEmail() == ""
                || user.getPhone() == "" || user.getSign() == "" || user.getClassify() == "" || user.getWealth() == "" || user.getSex() == ""){
            map.put("name","添加失败内容不能为空");
        }else{
            userRepository.save(user);
            map.put("name","添加成功");
        }
        return map;
    }

    @PostMapping("/deleteUser")
    @ResponseBody
    public  Map<String, String> deleteUser(User user){
        Map<String, String> map = new HashMap<>();
        if (user.getStudentNumber() == ""){
            map.put("name","学号不可以为空");
        }else{
            userRepository.delUser(user.getStudentNumber());
            map.put("name","删除成功");
        }
        return map;
    }

    @PostMapping("/updateUser")
    @ResponseBody
    public  Map<String, String> updateUser(User user){
        Map<String, String> map = new HashMap<>();
        if (user.getStudentNumber() == "" || user.getUsername() == "" || user.getPassWord() == "" || user.getEmail() == ""
        || user.getPhone() == "" || user.getSign() == "" || user.getClassify() == "" || user.getWealth() == "" || user.getSex() == ""){
            map.put("name","修改失败内容不能为空");
        }else{
            userRepository.updateUser(user.getStudentNumber(),
                    user.getUsername(),user.getPassWord()
                    ,user.getEmail(),user.getPhone(),user.getCity(),
                    user.getSign(),user.getClassify(),user.getWealth(),
                    user.getSex());
            map.put("name","修改成功");
        }
        return map;
    }
}
