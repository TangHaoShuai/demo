package com.example.demo.oilConreoller;


import com.example.demo.model.Exercise;
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
public class oilController {
    @ResponseBody
    @GetMapping("/youshuju")
    public Map<String, Object> youshuju(){

        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg",0);
        map.put("count", 10);
        List<Object> list = new ArrayList<Object>();
        String[] str = new String[]{"id","name","price","productionAddress","url"};
        String[] name = new String[]{"金龙鱼","心源康","福临门","紫苏籽油","葵王纯正玉米油","葵王纯正玉米油","菜花油","欧洲进口OL油"
                ," 艾伯瑞特级初榨橄榄油","西王非转基因玉米胚芽油"};
        String[] price = new String[]{"32","40","22","55","87","45","45","124"
                ," 67","87"};
        String[] productionAddress = new String[]{"广东深圳","广东东莞开发区","东北","杭州开发区","南宁北环路21号","浙江","广东深圳","广东深圳"
                ," 67","87"};
        for (int i = 0; i< 10 ; i++){
            Map<String,Object> map1 = new HashMap<>();
            map1.put(str[0],1000+i);
            map1.put(str[1],name[i]);
            map1.put(str[2],price[i]);
            map1.put(str[3],productionAddress[i]);
            map1.put(str[4],"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574863321351&di=db5b1d0b5a8e97cdd6e4073cbedfb957&imgtype=0&src=http%3A%2F%2Fpic15.nipic.com%2F20110703%2F3970232_182302078000_2.jpg");
            list.add(map1);
        }
        map.put("data",list);
        return map;
    }

}
