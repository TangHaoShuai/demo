package com.example.demo.controller;


import com.example.demo.dao.TheTestRepository;
import com.example.demo.model.Exercise;
import com.example.demo.model.TestPaper;
import com.example.demo.model.TheTest;
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
public class TheTestController {
    @Autowired
    private TheTestRepository theTestRepository;

    @ResponseBody
    @PostMapping("AddTheTestJson")
    public Map<String,String> AddTheTestJson(TheTest theTest){
        Map<String,String> map = new HashMap<>();
        if (theTest.getState() =="" || theTest.getTestPaperID()=="" || theTest.getTheEndOfTime()==""
        || theTest.getTestPaperID() =="" || theTest.getTheStartTime()==""){

            map.put("name","内容不可以为空");
        }else{
            theTestRepository.save(theTest);
            map.put("name","添加成功");
        }
        return map;
    }

    @ResponseBody
    @PostMapping("updateTheTestJson")
    public Map<String,String> updateTheTestJson(TheTest theTest){
        Map<String,String> map = new HashMap<>();
        if (theTest.getState() =="" || theTest.getTestPaperID()=="" || theTest.getTheEndOfTime()==""
                || theTest.getTestPaperID() =="" || theTest.getTheStartTime()=="" || theTest.getUid()==""){

            map.put("name","内容不可以为空");
        }else{
            theTestRepository.updateTheTest(theTest.getUid(),
                    theTest.getTheName(),theTest.getTheStartTime(),theTest.getTheEndOfTime()
            ,theTest.getTestPaperID(),theTest.getState());
            map.put("name","修改成功");
        }
        return map;
    }


    @ResponseBody
    @GetMapping("TheTestJson")
    public Map<String,Object> TheTestJosn(String val, Integer page, Integer limit){
        List<TheTest> count = theTestRepository.findAll();
        List<TheTest> theTests = theTestRepository.findTheTests("uid",(page-1)*limit,limit*page);
        if(val.length() > 0 ){
            List<TheTest> list = theTestRepository.findTheTestName(val,"uid",(page-1)*limit,limit*page);
            theTests = list;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg",0);
        map.put("count", count.size());
        List<Object> list = new ArrayList<Object>();
        String[] str = new String[]{"uid","theName","theStartTime","theEndOfTime","TestPaperID","State"};
        for (int i = 0; i< theTests.size() ; i++){
            Map<String,Object> map1 = new HashMap<>();
            map1.put(str[0], theTests.get(i).getUid());
            map1.put(str[1],theTests.get(i).getTheName());
            map1.put(str[2],theTests.get(i).getTheStartTime());
            map1.put(str[3],theTests.get(i).getTheEndOfTime());
            map1.put(str[4],theTests.get(i).getTestPaperID());
            map1.put(str[5],theTests.get(i).getState());
            list.add(map1);
        }
        map.put("data",list);
        return map;
    }

    @ResponseBody
    @PostMapping("deleteTheTest")
    public Map<String,String> deleteTheTest(TheTest theTest){
        Map<String, String> map = new HashMap<>();
        if (theTest.getUid() == ""){
            map.put("name","ID不可以为空");
        }else{
            theTestRepository.deleteTheTest(theTest.getUid());
            map.put("name","删除成功");
        }
        return map;
    }






    @ResponseBody
    @GetMapping("chaxun")
    public String chauxn(String name){
        if (name.equals("绿色")){
            String gerrn = " {\n" +
                    "  \"result\": {\n" +
                    "    \"songs\": [\n" +
                    "      {\n" +
                    "        \"id\": 1345848098,\n" +
                    "        \"name\": \"绿色\",\n" +
                    "        \"artists\": [\n" +
                    "          {\n" +
                    "            \"id\": 12382970,\n" +
                    "            \"name\": \"陈雪凝\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"album\": {\n" +
                    "          \"id\": 75528003,\n" +
                    "          \"name\": \"绿色\",\n" +
                    "          \"artist\": {\n" +
                    "            \"id\": 0,\n" +
                    "            \"name\": \"\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          \"publishTime\": 1550084210647,\n" +
                    "          \"size\": 1,\n" +
                    "          \"copyrightId\": 0,\n" +
                    "          \"status\": 0,\n" +
                    "          \"picId\": 109951163860425330,\n" +
                    "          \"mark\": 0\n" +
                    "        },\n" +
                    "        \"duration\": 269590,\n" +
                    "        \"copyrightId\": 0,\n" +
                    "        \"status\": 0,\n" +
                    "        \"alias\": [],\n" +
                    "        \"rtype\": 0,\n" +
                    "        \"ftype\": 0,\n" +
                    "        \"mvid\": 0,\n" +
                    "        \"fee\": 8,\n" +
                    "        \"rUrl\": null,\n" +
                    "        \"mark\": 0\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 1354262512,\n" +
                    "        \"name\": \"绿色\",\n" +
                    "        \"artists\": [\n" +
                    "          {\n" +
                    "            \"id\": 31764239,\n" +
                    "            \"name\": \"杨逍Free\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"album\": {\n" +
                    "          \"id\": 78197651,\n" +
                    "          \"name\": \"绿色\",\n" +
                    "          \"artist\": {\n" +
                    "            \"id\": 0,\n" +
                    "            \"name\": \"\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          \"publishTime\": 1553502824000,\n" +
                    "          \"size\": 1,\n" +
                    "          \"copyrightId\": 1372820,\n" +
                    "          \"status\": 0,\n" +
                    "          \"picId\": 109951163951043230,\n" +
                    "          \"mark\": 0\n" +
                    "        },\n" +
                    "        \"duration\": 269800,\n" +
                    "        \"copyrightId\": 1372820,\n" +
                    "        \"status\": 0,\n" +
                    "        \"alias\": [\n" +
                    "          \"原唱：陈雪凝\"\n" +
                    "        ],\n" +
                    "        \"rtype\": 0,\n" +
                    "        \"ftype\": 0,\n" +
                    "        \"mvid\": 0,\n" +
                    "        \"fee\": 0,\n" +
                    "        \"rUrl\": null,\n" +
                    "        \"mark\": 0\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 1399847104,\n" +
                    "        \"name\": \"绿色（抖音版）\",\n" +
                    "        \"artists\": [\n" +
                    "          {\n" +
                    "            \"id\": 12477029,\n" +
                    "            \"name\": \"朱习爱\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"album\": {\n" +
                    "          \"id\": 82821571,\n" +
                    "          \"name\": \"绿色（抖音版）\",\n" +
                    "          \"artist\": {\n" +
                    "            \"id\": 0,\n" +
                    "            \"name\": \"\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          \"publishTime\": 1572278400000,\n" +
                    "          \"size\": 0,\n" +
                    "          \"copyrightId\": -1,\n" +
                    "          \"status\": 1,\n" +
                    "          \"picId\": 109951164456133040,\n" +
                    "          \"mark\": 0\n" +
                    "        },\n" +
                    "        \"duration\": 219306,\n" +
                    "        \"copyrightId\": 1416542,\n" +
                    "        \"status\": 0,\n" +
                    "        \"alias\": [],\n" +
                    "        \"rtype\": 0,\n" +
                    "        \"ftype\": 0,\n" +
                    "        \"mvid\": 0,\n" +
                    "        \"fee\": 8,\n" +
                    "        \"rUrl\": null,\n" +
                    "        \"mark\": 0\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 1390136840,\n" +
                    "        \"name\": \"绿色\",\n" +
                    "        \"artists\": [\n" +
                    "          {\n" +
                    "            \"id\": 13568181,\n" +
                    "            \"name\": \"音墨泽\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"album\": {\n" +
                    "          \"id\": 81104766,\n" +
                    "          \"name\": \"颜色\",\n" +
                    "          \"artist\": {\n" +
                    "            \"id\": 0,\n" +
                    "            \"name\": \"\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          \"publishTime\": 1566576000000,\n" +
                    "          \"size\": 10,\n" +
                    "          \"copyrightId\": 0,\n" +
                    "          \"status\": 0,\n" +
                    "          \"picId\": 109951164317648530,\n" +
                    "          \"mark\": 0\n" +
                    "        },\n" +
                    "        \"duration\": 272384,\n" +
                    "        \"copyrightId\": 0,\n" +
                    "        \"status\": 0,\n" +
                    "        \"alias\": [],\n" +
                    "        \"rtype\": 0,\n" +
                    "        \"ftype\": 0,\n" +
                    "        \"mvid\": 0,\n" +
                    "        \"fee\": 8,\n" +
                    "        \"rUrl\": null,\n" +
                    "        \"mark\": 0\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 1358934727,\n" +
                    "        \"name\": \"绿色(DJ版)\",\n" +
                    "        \"artists\": [\n" +
                    "          {\n" +
                    "            \"id\": 31856651,\n" +
                    "            \"name\": \"六月\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"id\": 31892338,\n" +
                    "            \"name\": \"阿祥\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"id\": 12213335,\n" +
                    "            \"name\": \"枫宇辰\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"album\": {\n" +
                    "          \"id\": 78519131,\n" +
                    "          \"name\": \"绿色\",\n" +
                    "          \"artist\": {\n" +
                    "            \"id\": 0,\n" +
                    "            \"name\": \"\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          \"publishTime\": 1555257600000,\n" +
                    "          \"size\": 2,\n" +
                    "          \"copyrightId\": 1371818,\n" +
                    "          \"status\": 1,\n" +
                    "          \"picId\": 109951164000855580,\n" +
                    "          \"mark\": 0\n" +
                    "        },\n" +
                    "        \"duration\": 271962,\n" +
                    "        \"copyrightId\": 1416542,\n" +
                    "        \"status\": 0,\n" +
                    "        \"alias\": [],\n" +
                    "        \"rtype\": 0,\n" +
                    "        \"ftype\": 0,\n" +
                    "        \"mvid\": 0,\n" +
                    "        \"fee\": 8,\n" +
                    "        \"rUrl\": null,\n" +
                    "        \"mark\": 0\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 1403542588,\n" +
                    "        \"name\": \"绿色 (男生版)\",\n" +
                    "        \"artists\": [\n" +
                    "          {\n" +
                    "            \"id\": 31889398,\n" +
                    "            \"name\": \"Jesse T\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"album\": {\n" +
                    "          \"id\": 83348359,\n" +
                    "          \"name\": \"绿色 (男生版)\",\n" +
                    "          \"artist\": {\n" +
                    "            \"id\": 0,\n" +
                    "            \"name\": \"\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          \"publishTime\": 1572451200000,\n" +
                    "          \"size\": 1,\n" +
                    "          \"copyrightId\": 1416074,\n" +
                    "          \"status\": 1,\n" +
                    "          \"picId\": 109951164487803730,\n" +
                    "          \"mark\": 0\n" +
                    "        },\n" +
                    "        \"duration\": 93192,\n" +
                    "        \"copyrightId\": 1416074,\n" +
                    "        \"status\": 0,\n" +
                    "        \"alias\": [],\n" +
                    "        \"rtype\": 0,\n" +
                    "        \"ftype\": 0,\n" +
                    "        \"mvid\": 0,\n" +
                    "        \"fee\": 8,\n" +
                    "        \"rUrl\": null,\n" +
                    "        \"mark\": 8192\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 1356080772,\n" +
                    "        \"name\": \"绿色（Cover：陈雪凝）\",\n" +
                    "        \"artists\": [\n" +
                    "          {\n" +
                    "            \"id\": 27871785,\n" +
                    "            \"name\": \"梦逸飞\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"album\": {\n" +
                    "          \"id\": 78263953,\n" +
                    "          \"name\": \"绿色\",\n" +
                    "          \"artist\": {\n" +
                    "            \"id\": 0,\n" +
                    "            \"name\": \"\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          \"publishTime\": 1554178784465,\n" +
                    "          \"size\": 0,\n" +
                    "          \"copyrightId\": 0,\n" +
                    "          \"status\": 0,\n" +
                    "          \"picId\": 109951163969600860,\n" +
                    "          \"mark\": 0\n" +
                    "        },\n" +
                    "        \"duration\": 297257,\n" +
                    "        \"copyrightId\": 0,\n" +
                    "        \"status\": 0,\n" +
                    "        \"alias\": [],\n" +
                    "        \"rtype\": 0,\n" +
                    "        \"ftype\": 0,\n" +
                    "        \"mvid\": 0,\n" +
                    "        \"fee\": 0,\n" +
                    "        \"rUrl\": null,\n" +
                    "        \"mark\": 0\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 1393114759,\n" +
                    "        \"name\": \"绿色\",\n" +
                    "        \"artists\": [\n" +
                    "          {\n" +
                    "            \"id\": 13866036,\n" +
                    "            \"name\": \"柳建\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"album\": {\n" +
                    "          \"id\": 39688173,\n" +
                    "          \"name\": \"你、我、他\",\n" +
                    "          \"artist\": {\n" +
                    "            \"id\": 0,\n" +
                    "            \"name\": \"\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          \"publishTime\": 1528905600000,\n" +
                    "          \"size\": 5,\n" +
                    "          \"copyrightId\": 0,\n" +
                    "          \"status\": 0,\n" +
                    "          \"picId\": 109951163353759870,\n" +
                    "          \"mark\": 0\n" +
                    "        },\n" +
                    "        \"duration\": 233769,\n" +
                    "        \"copyrightId\": 0,\n" +
                    "        \"status\": 0,\n" +
                    "        \"alias\": [],\n" +
                    "        \"rtype\": 0,\n" +
                    "        \"ftype\": 0,\n" +
                    "        \"mvid\": 0,\n" +
                    "        \"fee\": 8,\n" +
                    "        \"rUrl\": null,\n" +
                    "        \"mark\": 0\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 1357652717,\n" +
                    "        \"name\": \"绿色\",\n" +
                    "        \"artists\": [\n" +
                    "          {\n" +
                    "            \"id\": 12477029,\n" +
                    "            \"name\": \"朱习爱\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"album\": {\n" +
                    "          \"id\": 78412699,\n" +
                    "          \"name\": \"绿色\",\n" +
                    "          \"artist\": {\n" +
                    "            \"id\": 0,\n" +
                    "            \"name\": \"\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          \"publishTime\": 1554739200000,\n" +
                    "          \"size\": 1,\n" +
                    "          \"copyrightId\": 725010,\n" +
                    "          \"status\": 1,\n" +
                    "          \"picId\": 109951163986855120,\n" +
                    "          \"mark\": 0\n" +
                    "        },\n" +
                    "        \"duration\": 264306,\n" +
                    "        \"copyrightId\": 725010,\n" +
                    "        \"status\": 0,\n" +
                    "        \"alias\": [],\n" +
                    "        \"rtype\": 0,\n" +
                    "        \"ftype\": 0,\n" +
                    "        \"mvid\": 0,\n" +
                    "        \"fee\": 8,\n" +
                    "        \"rUrl\": null,\n" +
                    "        \"mark\": 0\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 1388608299,\n" +
                    "        \"name\": \"绿色 (Live)\",\n" +
                    "        \"artists\": [\n" +
                    "          {\n" +
                    "            \"id\": 12382970,\n" +
                    "            \"name\": \"陈雪凝\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"album\": {\n" +
                    "          \"id\": 81351577,\n" +
                    "          \"name\": \"聚划算99划算盛典Live\",\n" +
                    "          \"artist\": {\n" +
                    "            \"id\": 0,\n" +
                    "            \"name\": \"\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          \"publishTime\": 1567958400000,\n" +
                    "          \"size\": 23,\n" +
                    "          \"copyrightId\": 1416434,\n" +
                    "          \"status\": 0,\n" +
                    "          \"picId\": 109951164353237630,\n" +
                    "          \"mark\": 0\n" +
                    "        },\n" +
                    "        \"duration\": 277717,\n" +
                    "        \"copyrightId\": 1416434,\n" +
                    "        \"status\": 0,\n" +
                    "        \"alias\": [],\n" +
                    "        \"rtype\": 0,\n" +
                    "        \"ftype\": 0,\n" +
                    "        \"mvid\": 10890701,\n" +
                    "        \"fee\": 8,\n" +
                    "        \"rUrl\": null,\n" +
                    "        \"mark\": 0\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 527327967,\n" +
                    "        \"name\": \"绿色\",\n" +
                    "        \"artists\": [\n" +
                    "          {\n" +
                    "            \"id\": 3937,\n" +
                    "            \"name\": \"刘斌\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"album\": {\n" +
                    "          \"id\": 38620039,\n" +
                    "          \"name\": \"群星合集 31\",\n" +
                    "          \"artist\": {\n" +
                    "            \"id\": 0,\n" +
                    "            \"name\": \"\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          \"publishTime\": -28800000,\n" +
                    "          \"size\": 500,\n" +
                    "          \"copyrightId\": 623010,\n" +
                    "          \"status\": 0,\n" +
                    "          \"picId\": 109951163288502720,\n" +
                    "          \"mark\": 0\n" +
                    "        },\n" +
                    "        \"duration\": 253706,\n" +
                    "        \"copyrightId\": 623010,\n" +
                    "        \"status\": 0,\n" +
                    "        \"alias\": [],\n" +
                    "        \"rtype\": 0,\n" +
                    "        \"ftype\": 0,\n" +
                    "        \"mvid\": 0,\n" +
                    "        \"fee\": 0,\n" +
                    "        \"rUrl\": null,\n" +
                    "        \"mark\": 0\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 526652161,\n" +
                    "        \"name\": \"绿色\",\n" +
                    "        \"artists\": [\n" +
                    "          {\n" +
                    "            \"id\": 12474518,\n" +
                    "            \"name\": \"卢律铭\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"album\": {\n" +
                    "          \"id\": 37099034,\n" +
                    "          \"name\": \"天黑请闭眼 原声带\",\n" +
                    "          \"artist\": {\n" +
                    "            \"id\": 0,\n" +
                    "            \"name\": \"\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          \"publishTime\": 1514476800000,\n" +
                    "          \"size\": 21,\n" +
                    "          \"copyrightId\": 36016,\n" +
                    "          \"status\": 0,\n" +
                    "          \"transNames\": [\n" +
                    "            \"Before it's dark (Original TV series soundtrack from  \\\"Close your eyes before it's dark\\\")\"\n" +
                    "          ],\n" +
                    "          \"picId\": 109951163094536060,\n" +
                    "          \"mark\": 0\n" +
                    "        },\n" +
                    "        \"duration\": 191821,\n" +
                    "        \"copyrightId\": 1400821,\n" +
                    "        \"status\": 0,\n" +
                    "        \"alias\": [\n" +
                    "          \"Green\"\n" +
                    "        ],\n" +
                    "        \"rtype\": 0,\n" +
                    "        \"ftype\": 0,\n" +
                    "        \"mvid\": 0,\n" +
                    "        \"fee\": 8,\n" +
                    "        \"rUrl\": null,\n" +
                    "        \"mark\": 0\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 1392499642,\n" +
                    "        \"name\": \"绿色\",\n" +
                    "        \"artists\": [\n" +
                    "          {\n" +
                    "            \"id\": 33295030,\n" +
                    "            \"name\": \"小爱的钢琴曲\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"album\": {\n" +
                    "          \"id\": 81829905,\n" +
                    "          \"name\": \"必听18首钢琴曲 - 2019国内最好听的钢琴轻音乐为了一个人休息\",\n" +
                    "          \"artist\": {\n" +
                    "            \"id\": 0,\n" +
                    "            \"name\": \"\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          \"publishTime\": 1568649600000,\n" +
                    "          \"size\": 0,\n" +
                    "          \"copyrightId\": 743010,\n" +
                    "          \"status\": 1,\n" +
                    "          \"picId\": 109951164379619140,\n" +
                    "          \"mark\": 0\n" +
                    "        },\n" +
                    "        \"duration\": 373999,\n" +
                    "        \"copyrightId\": 743010,\n" +
                    "        \"status\": 0,\n" +
                    "        \"alias\": [],\n" +
                    "        \"rtype\": 0,\n" +
                    "        \"ftype\": 0,\n" +
                    "        \"mvid\": 0,\n" +
                    "        \"fee\": 8,\n" +
                    "        \"rUrl\": null,\n" +
                    "        \"mark\": 8320\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 1325897054,\n" +
                    "        \"name\": \"绿色丛林\",\n" +
                    "        \"artists\": [\n" +
                    "          {\n" +
                    "            \"id\": 1203045,\n" +
                    "            \"name\": \"艾热 AIR\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"id\": 1155005,\n" +
                    "            \"name\": \"Terry Zhong\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"album\": {\n" +
                    "          \"id\": 74269023,\n" +
                    "          \"name\": \"2018 丛林电音主题曲专辑\",\n" +
                    "          \"artist\": {\n" +
                    "            \"id\": 0,\n" +
                    "            \"name\": \"\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          \"publishTime\": 1542902400000,\n" +
                    "          \"size\": 5,\n" +
                    "          \"copyrightId\": 1415904,\n" +
                    "          \"status\": 0,\n" +
                    "          \"picId\": 109951163676248260,\n" +
                    "          \"mark\": 0\n" +
                    "        },\n" +
                    "        \"duration\": 216521,\n" +
                    "        \"copyrightId\": 1415904,\n" +
                    "        \"status\": 0,\n" +
                    "        \"alias\": [\n" +
                    "          \"2018丛林电子音乐节主题曲\"\n" +
                    "        ],\n" +
                    "        \"rtype\": 0,\n" +
                    "        \"ftype\": 0,\n" +
                    "        \"mvid\": 0,\n" +
                    "        \"fee\": 8,\n" +
                    "        \"rUrl\": null,\n" +
                    "        \"mark\": 0\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 1406271333,\n" +
                    "        \"name\": \"绿色健康小清新FREESTYLE\",\n" +
                    "        \"artists\": [\n" +
                    "          {\n" +
                    "            \"id\": 12600748,\n" +
                    "            \"name\": \"宇宙怪獣Zetton\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"id\": 13113408,\n" +
                    "            \"name\": \"GREET-V眼圈\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"album\": {\n" +
                    "          \"id\": 83643199,\n" +
                    "          \"name\": \"绿色健康小清新Free style\",\n" +
                    "          \"artist\": {\n" +
                    "            \"id\": 0,\n" +
                    "            \"name\": \"\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          \"publishTime\": 1574846837104,\n" +
                    "          \"size\": 1,\n" +
                    "          \"copyrightId\": 0,\n" +
                    "          \"status\": 0,\n" +
                    "          \"picId\": 109951164513875620,\n" +
                    "          \"mark\": 0\n" +
                    "        },\n" +
                    "        \"duration\": 144000,\n" +
                    "        \"copyrightId\": 0,\n" +
                    "        \"status\": 0,\n" +
                    "        \"alias\": [],\n" +
                    "        \"rtype\": 0,\n" +
                    "        \"ftype\": 0,\n" +
                    "        \"mvid\": 0,\n" +
                    "        \"fee\": 8,\n" +
                    "        \"rUrl\": null,\n" +
                    "        \"mark\": 0\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 1404740625,\n" +
                    "        \"name\": \"绿色废人\",\n" +
                    "        \"artists\": [\n" +
                    "          {\n" +
                    "            \"id\": 12664848,\n" +
                    "            \"name\": \"火晚晴\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"id\": 12867897,\n" +
                    "            \"name\": \"CHEND\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"album\": {\n" +
                    "          \"id\": 83502661,\n" +
                    "          \"name\": \"绿色废人\",\n" +
                    "          \"artist\": {\n" +
                    "            \"id\": 0,\n" +
                    "            \"name\": \"\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          \"publishTime\": 1574159578646,\n" +
                    "          \"size\": 1,\n" +
                    "          \"copyrightId\": 0,\n" +
                    "          \"status\": 0,\n" +
                    "          \"picId\": 109951164498352100,\n" +
                    "          \"mark\": 0\n" +
                    "        },\n" +
                    "        \"duration\": 162304,\n" +
                    "        \"copyrightId\": 0,\n" +
                    "        \"status\": 0,\n" +
                    "        \"alias\": [],\n" +
                    "        \"rtype\": 0,\n" +
                    "        \"ftype\": 0,\n" +
                    "        \"mvid\": 0,\n" +
                    "        \"fee\": 8,\n" +
                    "        \"rUrl\": null,\n" +
                    "        \"mark\": 0\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 1380398595,\n" +
                    "        \"name\": \"绿色家园\",\n" +
                    "        \"artists\": [\n" +
                    "          {\n" +
                    "            \"id\": 30547841,\n" +
                    "            \"name\": \"泽旺拉姆\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"album\": {\n" +
                    "          \"id\": 80626694,\n" +
                    "          \"name\": \"绿色家园\",\n" +
                    "          \"artist\": {\n" +
                    "            \"id\": 0,\n" +
                    "            \"name\": \"\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          \"publishTime\": 1564159733154,\n" +
                    "          \"size\": 1,\n" +
                    "          \"copyrightId\": 0,\n" +
                    "          \"status\": 0,\n" +
                    "          \"picId\": 109951164242695970,\n" +
                    "          \"mark\": 0\n" +
                    "        },\n" +
                    "        \"duration\": 218709,\n" +
                    "        \"copyrightId\": 0,\n" +
                    "        \"status\": 0,\n" +
                    "        \"alias\": [],\n" +
                    "        \"rtype\": 0,\n" +
                    "        \"ftype\": 0,\n" +
                    "        \"mvid\": 0,\n" +
                    "        \"fee\": 8,\n" +
                    "        \"rUrl\": null,\n" +
                    "        \"mark\": 0\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 1406292033,\n" +
                    "        \"name\": \"214（Cover：Double C）\",\n" +
                    "        \"artists\": [\n" +
                    "          {\n" +
                    "            \"id\": 33017945,\n" +
                    "            \"name\": \"绿色学长\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"album\": {\n" +
                    "          \"id\": 83670867,\n" +
                    "          \"name\": \"2.14\",\n" +
                    "          \"artist\": {\n" +
                    "            \"id\": 0,\n" +
                    "            \"name\": \"\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          \"publishTime\": 1574854443221,\n" +
                    "          \"size\": 1,\n" +
                    "          \"copyrightId\": 0,\n" +
                    "          \"status\": 0,\n" +
                    "          \"picId\": 109951164514069500,\n" +
                    "          \"mark\": 0\n" +
                    "        },\n" +
                    "        \"duration\": 156447,\n" +
                    "        \"copyrightId\": 0,\n" +
                    "        \"status\": 0,\n" +
                    "        \"alias\": [],\n" +
                    "        \"rtype\": 0,\n" +
                    "        \"ftype\": 0,\n" +
                    "        \"mvid\": 0,\n" +
                    "        \"fee\": 0,\n" +
                    "        \"rUrl\": null,\n" +
                    "        \"mark\": 0\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 5377454,\n" +
                    "        \"name\": \"그래 늦지 않았어\",\n" +
                    "        \"artists\": [\n" +
                    "          {\n" +
                    "            \"id\": 126820,\n" +
                    "            \"name\": \"绿色地带\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"album\": {\n" +
                    "          \"id\": 527174,\n" +
                    "          \"name\": \"일곱번째 다이어리\",\n" +
                    "          \"artist\": {\n" +
                    "            \"id\": 0,\n" +
                    "            \"name\": \"\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          \"publishTime\": 1256054400000,\n" +
                    "          \"size\": 10,\n" +
                    "          \"copyrightId\": 0,\n" +
                    "          \"status\": 1,\n" +
                    "          \"transNames\": [\n" +
                    "            \"第七本日记\"\n" +
                    "          ],\n" +
                    "          \"picId\": 6656443394676221,\n" +
                    "          \"mark\": 0\n" +
                    "        },\n" +
                    "        \"duration\": 234422,\n" +
                    "        \"copyrightId\": 0,\n" +
                    "        \"status\": 0,\n" +
                    "        \"alias\": [],\n" +
                    "        \"rtype\": 0,\n" +
                    "        \"ftype\": 0,\n" +
                    "        \"transNames\": [\n" +
                    "          \"还好不是很晚\"\n" +
                    "        ],\n" +
                    "        \"mvid\": 0,\n" +
                    "        \"fee\": 0,\n" +
                    "        \"rUrl\": null,\n" +
                    "        \"mark\": 0\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 1311347589,\n" +
                    "        \"name\": \"绿色的大爱 \",\n" +
                    "        \"artists\": [\n" +
                    "          {\n" +
                    "            \"id\": 3072,\n" +
                    "            \"name\": \"韩磊\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"album\": {\n" +
                    "          \"id\": 73467798,\n" +
                    "          \"name\": \"绿色的大爱\",\n" +
                    "          \"artist\": {\n" +
                    "            \"id\": 0,\n" +
                    "            \"name\": \"\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          \"publishTime\": 1538064000007,\n" +
                    "          \"size\": 2,\n" +
                    "          \"copyrightId\": 754021,\n" +
                    "          \"status\": 0,\n" +
                    "          \"picId\": 109951163569817420,\n" +
                    "          \"mark\": 0\n" +
                    "        },\n" +
                    "        \"duration\": 242876,\n" +
                    "        \"copyrightId\": 754021,\n" +
                    "        \"status\": 0,\n" +
                    "        \"alias\": [],\n" +
                    "        \"rtype\": 0,\n" +
                    "        \"ftype\": 0,\n" +
                    "        \"mvid\": 10801258,\n" +
                    "        \"fee\": 8,\n" +
                    "        \"rUrl\": null,\n" +
                    "        \"mark\": 0\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 1380849171,\n" +
                    "        \"name\": \"绿色的草原\",\n" +
                    "        \"artists\": [\n" +
                    "          {\n" +
                    "            \"id\": 6847,\n" +
                    "            \"name\": \"泽旺多吉\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"album\": {\n" +
                    "          \"id\": 80658168,\n" +
                    "          \"name\": \"绿色的草原\",\n" +
                    "          \"artist\": {\n" +
                    "            \"id\": 0,\n" +
                    "            \"name\": \"\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          \"publishTime\": 1564416000000,\n" +
                    "          \"size\": 0,\n" +
                    "          \"copyrightId\": 1415887,\n" +
                    "          \"status\": 1,\n" +
                    "          \"picId\": 109951164248873700,\n" +
                    "          \"mark\": 0\n" +
                    "        },\n" +
                    "        \"duration\": 249208,\n" +
                    "        \"copyrightId\": 1415887,\n" +
                    "        \"status\": 0,\n" +
                    "        \"alias\": [],\n" +
                    "        \"rtype\": 0,\n" +
                    "        \"ftype\": 0,\n" +
                    "        \"mvid\": 0,\n" +
                    "        \"fee\": 8,\n" +
                    "        \"rUrl\": null,\n" +
                    "        \"mark\": 0\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 1371093391,\n" +
                    "        \"name\": \"绿色曙光\",\n" +
                    "        \"artists\": [\n" +
                    "          {\n" +
                    "            \"id\": 12138049,\n" +
                    "            \"name\": \"雪碧说唱\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"id\": 12704089,\n" +
                    "            \"name\": \"极地是好乐队\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"album\": {\n" +
                    "          \"id\": 79718850,\n" +
                    "          \"name\": \"绿色曙光\",\n" +
                    "          \"artist\": {\n" +
                    "            \"id\": 0,\n" +
                    "            \"name\": \"\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          \"publishTime\": 1560182400000,\n" +
                    "          \"size\": 2,\n" +
                    "          \"copyrightId\": 1391818,\n" +
                    "          \"status\": 1,\n" +
                    "          \"picId\": 109951164144196660,\n" +
                    "          \"mark\": 0\n" +
                    "        },\n" +
                    "        \"duration\": 186250,\n" +
                    "        \"copyrightId\": 1416503,\n" +
                    "        \"status\": 0,\n" +
                    "        \"alias\": [],\n" +
                    "        \"rtype\": 0,\n" +
                    "        \"ftype\": 0,\n" +
                    "        \"mvid\": 0,\n" +
                    "        \"fee\": 8,\n" +
                    "        \"rUrl\": null,\n" +
                    "        \"mark\": 0\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 93460,\n" +
                    "        \"name\": \"绿色的日子\",\n" +
                    "        \"artists\": [\n" +
                    "          {\n" +
                    "            \"id\": 3070,\n" +
                    "            \"name\": \"黄玠\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"album\": {\n" +
                    "          \"id\": 9172,\n" +
                    "          \"name\": \"绿色的日子\",\n" +
                    "          \"artist\": {\n" +
                    "            \"id\": 0,\n" +
                    "            \"name\": \"\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          \"publishTime\": 1180540800000,\n" +
                    "          \"size\": 6,\n" +
                    "          \"copyrightId\": 0,\n" +
                    "          \"status\": 1,\n" +
                    "          \"picId\": 54975581401134,\n" +
                    "          \"mark\": 0\n" +
                    "        },\n" +
                    "        \"duration\": 293306,\n" +
                    "        \"copyrightId\": 682010,\n" +
                    "        \"status\": 0,\n" +
                    "        \"alias\": [],\n" +
                    "        \"rtype\": 0,\n" +
                    "        \"ftype\": 0,\n" +
                    "        \"mvid\": 0,\n" +
                    "        \"fee\": 1,\n" +
                    "        \"rUrl\": null,\n" +
                    "        \"mark\": 0\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 1313102614,\n" +
                    "        \"name\": \"绿色家园\",\n" +
                    "        \"artists\": [\n" +
                    "          {\n" +
                    "            \"id\": 6109,\n" +
                    "            \"name\": \"伊洋\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"id\": 10879,\n" +
                    "            \"name\": \"张晓棠\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"album\": {\n" +
                    "          \"id\": 73468080,\n" +
                    "          \"name\": \"绿色家园\",\n" +
                    "          \"artist\": {\n" +
                    "            \"id\": 0,\n" +
                    "            \"name\": \"\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          \"publishTime\": 1538236800007,\n" +
                    "          \"size\": 1,\n" +
                    "          \"copyrightId\": 32002,\n" +
                    "          \"status\": 0,\n" +
                    "          \"picId\": 109951163576507040,\n" +
                    "          \"mark\": 0\n" +
                    "        },\n" +
                    "        \"duration\": 312006,\n" +
                    "        \"copyrightId\": 32002,\n" +
                    "        \"status\": 0,\n" +
                    "        \"alias\": [],\n" +
                    "        \"rtype\": 0,\n" +
                    "        \"ftype\": 0,\n" +
                    "        \"mvid\": 0,\n" +
                    "        \"fee\": 0,\n" +
                    "        \"rUrl\": null,\n" +
                    "        \"mark\": 0\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 1317624552,\n" +
                    "        \"name\": \"绿色的梦想\",\n" +
                    "        \"artists\": [\n" +
                    "          {\n" +
                    "            \"id\": 12475724,\n" +
                    "            \"name\": \"夏侯钰涵\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"album\": {\n" +
                    "          \"id\": 73862124,\n" +
                    "          \"name\": \"《绿色的梦想》\",\n" +
                    "          \"artist\": {\n" +
                    "            \"id\": 0,\n" +
                    "            \"name\": \"\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          \"publishTime\": 1539394042177,\n" +
                    "          \"size\": 1,\n" +
                    "          \"copyrightId\": 0,\n" +
                    "          \"status\": 0,\n" +
                    "          \"picId\": 109951163600518560,\n" +
                    "          \"mark\": 0\n" +
                    "        },\n" +
                    "        \"duration\": 294466,\n" +
                    "        \"copyrightId\": 0,\n" +
                    "        \"status\": 0,\n" +
                    "        \"alias\": [],\n" +
                    "        \"rtype\": 0,\n" +
                    "        \"ftype\": 0,\n" +
                    "        \"mvid\": 0,\n" +
                    "        \"fee\": 0,\n" +
                    "        \"rUrl\": null,\n" +
                    "        \"mark\": 0\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 5377460,\n" +
                    "        \"name\": \"사랑을 할거야\",\n" +
                    "        \"artists\": [\n" +
                    "          {\n" +
                    "            \"id\": 126820,\n" +
                    "            \"name\": \"绿色地带\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"album\": {\n" +
                    "          \"id\": 527174,\n" +
                    "          \"name\": \"일곱번째 다이어리\",\n" +
                    "          \"artist\": {\n" +
                    "            \"id\": 0,\n" +
                    "            \"name\": \"\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          \"publishTime\": 1256054400000,\n" +
                    "          \"size\": 10,\n" +
                    "          \"copyrightId\": 0,\n" +
                    "          \"status\": 1,\n" +
                    "          \"transNames\": [\n" +
                    "            \"第七本日记\"\n" +
                    "          ],\n" +
                    "          \"picId\": 6656443394676221,\n" +
                    "          \"mark\": 0\n" +
                    "        },\n" +
                    "        \"duration\": 287791,\n" +
                    "        \"copyrightId\": 0,\n" +
                    "        \"status\": 0,\n" +
                    "        \"alias\": [],\n" +
                    "        \"rtype\": 0,\n" +
                    "        \"ftype\": 0,\n" +
                    "        \"transNames\": [\n" +
                    "          \"要爱\"\n" +
                    "        ],\n" +
                    "        \"mvid\": 0,\n" +
                    "        \"fee\": 0,\n" +
                    "        \"rUrl\": null,\n" +
                    "        \"mark\": 0\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 520460725,\n" +
                    "        \"name\": \"回心转意\",\n" +
                    "        \"artists\": [\n" +
                    "          {\n" +
                    "            \"id\": 12894245,\n" +
                    "            \"name\": \"绿色森林\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"album\": {\n" +
                    "          \"id\": 36854178,\n" +
                    "          \"name\": \"绿色森林\",\n" +
                    "          \"artist\": {\n" +
                    "            \"id\": 0,\n" +
                    "            \"name\": \"\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          \"publishTime\": 1104508800007,\n" +
                    "          \"size\": 8,\n" +
                    "          \"copyrightId\": 0,\n" +
                    "          \"status\": 0,\n" +
                    "          \"picId\": 109951163071972050,\n" +
                    "          \"mark\": 0\n" +
                    "        },\n" +
                    "        \"duration\": 277080,\n" +
                    "        \"copyrightId\": 1416163,\n" +
                    "        \"status\": 0,\n" +
                    "        \"alias\": [],\n" +
                    "        \"rtype\": 0,\n" +
                    "        \"ftype\": 0,\n" +
                    "        \"mvid\": 0,\n" +
                    "        \"fee\": 1,\n" +
                    "        \"rUrl\": null,\n" +
                    "        \"mark\": 8192\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 224163,\n" +
                    "        \"name\": \"绿色之梦\",\n" +
                    "        \"artists\": [\n" +
                    "          {\n" +
                    "            \"id\": 7540,\n" +
                    "            \"name\": \"德德玛\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"album\": {\n" +
                    "          \"id\": 22648,\n" +
                    "          \"name\": \"我的根在草原\",\n" +
                    "          \"artist\": {\n" +
                    "            \"id\": 0,\n" +
                    "            \"name\": \"\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          \"publishTime\": 1188316800007,\n" +
                    "          \"size\": 13,\n" +
                    "          \"copyrightId\": 372013,\n" +
                    "          \"status\": 1,\n" +
                    "          \"picId\": 60473139533536,\n" +
                    "          \"mark\": 0\n" +
                    "        },\n" +
                    "        \"duration\": 257437,\n" +
                    "        \"copyrightId\": 372013,\n" +
                    "        \"status\": 0,\n" +
                    "        \"alias\": [],\n" +
                    "        \"rtype\": 0,\n" +
                    "        \"ftype\": 0,\n" +
                    "        \"mvid\": 0,\n" +
                    "        \"fee\": 8,\n" +
                    "        \"rUrl\": null,\n" +
                    "        \"mark\": 0\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 25923498,\n" +
                    "        \"name\": \"绿色背影\",\n" +
                    "        \"artists\": [\n" +
                    "          {\n" +
                    "            \"id\": 7517,\n" +
                    "            \"name\": \"张迈\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"album\": {\n" +
                    "          \"id\": 2341369,\n" +
                    "          \"name\": \"绿色背影\",\n" +
                    "          \"artist\": {\n" +
                    "            \"id\": 0,\n" +
                    "            \"name\": \"\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          \"publishTime\": 1158249600007,\n" +
                    "          \"size\": 12,\n" +
                    "          \"copyrightId\": 0,\n" +
                    "          \"status\": 1,\n" +
                    "          \"picId\": 3240260767520327,\n" +
                    "          \"mark\": 0\n" +
                    "        },\n" +
                    "        \"duration\": 286000,\n" +
                    "        \"copyrightId\": 22019,\n" +
                    "        \"status\": 0,\n" +
                    "        \"alias\": [],\n" +
                    "        \"rtype\": 0,\n" +
                    "        \"ftype\": 0,\n" +
                    "        \"mvid\": 0,\n" +
                    "        \"fee\": 8,\n" +
                    "        \"rUrl\": null,\n" +
                    "        \"mark\": 0\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"id\": 521493405,\n" +
                    "        \"name\": \"绿色北京\",\n" +
                    "        \"artists\": [\n" +
                    "          {\n" +
                    "            \"id\": 2119,\n" +
                    "            \"name\": \"蔡国庆\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"id\": 7159,\n" +
                    "            \"name\": \"白雪\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"album\": {\n" +
                    "          \"id\": 36875087,\n" +
                    "          \"name\": \"世园金曲\",\n" +
                    "          \"artist\": {\n" +
                    "            \"id\": 0,\n" +
                    "            \"name\": \"\",\n" +
                    "            \"picUrl\": null,\n" +
                    "            \"alias\": [],\n" +
                    "            \"albumSize\": 0,\n" +
                    "            \"picId\": 0,\n" +
                    "            \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "            \"img1v1\": 0,\n" +
                    "            \"trans\": null\n" +
                    "          },\n" +
                    "          \"publishTime\": 1512316800000,\n" +
                    "          \"size\": 9,\n" +
                    "          \"copyrightId\": 534010,\n" +
                    "          \"status\": 0,\n" +
                    "          \"picId\": 109951163073869470,\n" +
                    "          \"mark\": 0\n" +
                    "        },\n" +
                    "        \"duration\": 190976,\n" +
                    "        \"copyrightId\": 534010,\n" +
                    "        \"status\": 0,\n" +
                    "        \"alias\": [],\n" +
                    "        \"rtype\": 0,\n" +
                    "        \"ftype\": 0,\n" +
                    "        \"mvid\": 0,\n" +
                    "        \"fee\": 0,\n" +
                    "        \"rUrl\": null,\n" +
                    "        \"mark\": 0\n" +
                    "      }\n" +
                    "    ],\n" +
                    "    \"songCount\": 600\n" +
                    "  },\n" +
                    "  \"code\": 200\n" +
                    "}";
            return gerrn;
        }else{
            return  " {\n" +
                    "    \"result\": {\n" +
                    "        \"songs\": [\n" +
                    "            {\n" +
                    "                \"id\": 1378491298,\n" +
                    "                \"name\": \"愛にできることはまだあるかい\",\n" +
                    "                \"artists\": [\n" +
                    "                    {\n" +
                    "                        \"id\": 21132,\n" +
                    "                        \"name\": \"RADWIMPS\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    }\n" +
                    "                ],\n" +
                    "                \"album\": {\n" +
                    "                    \"id\": 80440087,\n" +
                    "                    \"name\": \"天気の子\",\n" +
                    "                    \"artist\": {\n" +
                    "                        \"id\": 0,\n" +
                    "                        \"name\": \"\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    },\n" +
                    "                    \"publishTime\": 1563465600000,\n" +
                    "                    \"size\": 31,\n" +
                    "                    \"copyrightId\": 587012,\n" +
                    "                    \"status\": 1,\n" +
                    "                    \"picId\": 109951164220136540,\n" +
                    "                    \"alia\": [\n" +
                    "                        \"动画电影《天气之子》原声带\"\n" +
                    "                    ],\n" +
                    "                    \"mark\": 0\n" +
                    "                },\n" +
                    "                \"duration\": 414466,\n" +
                    "                \"copyrightId\": 587012,\n" +
                    "                \"status\": 0,\n" +
                    "                \"alias\": [\n" +
                    "                    \"动画电影《天气之子》主题曲\"\n" +
                    "                ],\n" +
                    "                \"rtype\": 0,\n" +
                    "                \"ftype\": 0,\n" +
                    "                \"mvid\": 10900824,\n" +
                    "                \"fee\": 1,\n" +
                    "                \"rUrl\": null,\n" +
                    "                \"mark\": 8192\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": 1378491296,\n" +
                    "                \"name\": \"グランドエスケープ (Movie edit)\",\n" +
                    "                \"artists\": [\n" +
                    "                    {\n" +
                    "                        \"id\": 32664726,\n" +
                    "                        \"name\": \"三浦透子\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    }\n" +
                    "                ],\n" +
                    "                \"album\": {\n" +
                    "                    \"id\": 80440087,\n" +
                    "                    \"name\": \"天気の子\",\n" +
                    "                    \"artist\": {\n" +
                    "                        \"id\": 0,\n" +
                    "                        \"name\": \"\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    },\n" +
                    "                    \"publishTime\": 1563465600000,\n" +
                    "                    \"size\": 31,\n" +
                    "                    \"copyrightId\": 587012,\n" +
                    "                    \"status\": 1,\n" +
                    "                    \"picId\": 109951164220136540,\n" +
                    "                    \"alia\": [\n" +
                    "                        \"动画电影《天气之子》原声带\"\n" +
                    "                    ],\n" +
                    "                    \"mark\": 0\n" +
                    "                },\n" +
                    "                \"duration\": 188066,\n" +
                    "                \"copyrightId\": 587012,\n" +
                    "                \"status\": 0,\n" +
                    "                \"alias\": [\n" +
                    "                    \"动画电影《天气之子》主题曲\"\n" +
                    "                ],\n" +
                    "                \"rtype\": 0,\n" +
                    "                \"ftype\": 0,\n" +
                    "                \"mvid\": 0,\n" +
                    "                \"fee\": 1,\n" +
                    "                \"rUrl\": null,\n" +
                    "                \"mark\": 8192\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": 1378492147,\n" +
                    "                \"name\": \"大丈夫 (Movie edit)\",\n" +
                    "                \"artists\": [\n" +
                    "                    {\n" +
                    "                        \"id\": 21132,\n" +
                    "                        \"name\": \"RADWIMPS\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    }\n" +
                    "                ],\n" +
                    "                \"album\": {\n" +
                    "                    \"id\": 80440087,\n" +
                    "                    \"name\": \"天気の子\",\n" +
                    "                    \"artist\": {\n" +
                    "                        \"id\": 0,\n" +
                    "                        \"name\": \"\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    },\n" +
                    "                    \"publishTime\": 1563465600000,\n" +
                    "                    \"size\": 31,\n" +
                    "                    \"copyrightId\": 587012,\n" +
                    "                    \"status\": 1,\n" +
                    "                    \"picId\": 109951164220136540,\n" +
                    "                    \"alia\": [\n" +
                    "                        \"动画电影《天气之子》原声带\"\n" +
                    "                    ],\n" +
                    "                    \"mark\": 0\n" +
                    "                },\n" +
                    "                \"duration\": 258373,\n" +
                    "                \"copyrightId\": 587012,\n" +
                    "                \"status\": 0,\n" +
                    "                \"alias\": [\n" +
                    "                    \"动画电影《天气之子》主题曲\"\n" +
                    "                ],\n" +
                    "                \"rtype\": 0,\n" +
                    "                \"ftype\": 0,\n" +
                    "                \"mvid\": 10900824,\n" +
                    "                \"fee\": 1,\n" +
                    "                \"rUrl\": null,\n" +
                    "                \"mark\": 8192\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": 1378492142,\n" +
                    "                \"name\": \"愛にできることはまだあるかい (Movie edit)\",\n" +
                    "                \"artists\": [\n" +
                    "                    {\n" +
                    "                        \"id\": 21132,\n" +
                    "                        \"name\": \"RADWIMPS\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    }\n" +
                    "                ],\n" +
                    "                \"album\": {\n" +
                    "                    \"id\": 80440087,\n" +
                    "                    \"name\": \"天気の子\",\n" +
                    "                    \"artist\": {\n" +
                    "                        \"id\": 0,\n" +
                    "                        \"name\": \"\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    },\n" +
                    "                    \"publishTime\": 1563465600000,\n" +
                    "                    \"size\": 31,\n" +
                    "                    \"copyrightId\": 587012,\n" +
                    "                    \"status\": 1,\n" +
                    "                    \"picId\": 109951164220136540,\n" +
                    "                    \"alia\": [\n" +
                    "                        \"动画电影《天气之子》原声带\"\n" +
                    "                    ],\n" +
                    "                    \"mark\": 0\n" +
                    "                },\n" +
                    "                \"duration\": 150653,\n" +
                    "                \"copyrightId\": 587012,\n" +
                    "                \"status\": 0,\n" +
                    "                \"alias\": [\n" +
                    "                    \"动画电影《天气之子》主题曲\"\n" +
                    "                ],\n" +
                    "                \"rtype\": 0,\n" +
                    "                \"ftype\": 0,\n" +
                    "                \"mvid\": 0,\n" +
                    "                \"fee\": 1,\n" +
                    "                \"rUrl\": null,\n" +
                    "                \"mark\": 8192\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": 1378491293,\n" +
                    "                \"name\": \"祝祭 (Movie edit)\",\n" +
                    "                \"artists\": [\n" +
                    "                    {\n" +
                    "                        \"id\": 32664726,\n" +
                    "                        \"name\": \"三浦透子\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    }\n" +
                    "                ],\n" +
                    "                \"album\": {\n" +
                    "                    \"id\": 80440087,\n" +
                    "                    \"name\": \"天気の子\",\n" +
                    "                    \"artist\": {\n" +
                    "                        \"id\": 0,\n" +
                    "                        \"name\": \"\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    },\n" +
                    "                    \"publishTime\": 1563465600000,\n" +
                    "                    \"size\": 31,\n" +
                    "                    \"copyrightId\": 587012,\n" +
                    "                    \"status\": 1,\n" +
                    "                    \"picId\": 109951164220136540,\n" +
                    "                    \"alia\": [\n" +
                    "                        \"动画电影《天气之子》原声带\"\n" +
                    "                    ],\n" +
                    "                    \"mark\": 0\n" +
                    "                },\n" +
                    "                \"duration\": 156160,\n" +
                    "                \"copyrightId\": 587012,\n" +
                    "                \"status\": 0,\n" +
                    "                \"alias\": [\n" +
                    "                    \"动画电影《天气之子》主题曲\"\n" +
                    "                ],\n" +
                    "                \"rtype\": 0,\n" +
                    "                \"ftype\": 0,\n" +
                    "                \"mvid\": 0,\n" +
                    "                \"fee\": 1,\n" +
                    "                \"rUrl\": null,\n" +
                    "                \"mark\": 8192\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": 1400243461,\n" +
                    "                \"name\": \"大丈夫\",\n" +
                    "                \"artists\": [\n" +
                    "                    {\n" +
                    "                        \"id\": 21132,\n" +
                    "                        \"name\": \"RADWIMPS\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    }\n" +
                    "                ],\n" +
                    "                \"album\": {\n" +
                    "                    \"id\": 82894738,\n" +
                    "                    \"name\": \"天気の子 complete version\",\n" +
                    "                    \"artist\": {\n" +
                    "                        \"id\": 0,\n" +
                    "                        \"name\": \"\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    },\n" +
                    "                    \"publishTime\": 1572883200000,\n" +
                    "                    \"size\": 6,\n" +
                    "                    \"copyrightId\": 587012,\n" +
                    "                    \"status\": 0,\n" +
                    "                    \"picId\": 109951164459591380,\n" +
                    "                    \"mark\": 0\n" +
                    "                },\n" +
                    "                \"duration\": 335146,\n" +
                    "                \"copyrightId\": 587012,\n" +
                    "                \"status\": 0,\n" +
                    "                \"alias\": [\n" +
                    "                    \"动画电影《天气之子》主题曲\"\n" +
                    "                ],\n" +
                    "                \"rtype\": 0,\n" +
                    "                \"ftype\": 0,\n" +
                    "                \"mvid\": 10900035,\n" +
                    "                \"fee\": 4,\n" +
                    "                \"rUrl\": null,\n" +
                    "                \"mark\": 0\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": 1378492146,\n" +
                    "                \"name\": \"花火大会\",\n" +
                    "                \"artists\": [\n" +
                    "                    {\n" +
                    "                        \"id\": 21132,\n" +
                    "                        \"name\": \"RADWIMPS\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    }\n" +
                    "                ],\n" +
                    "                \"album\": {\n" +
                    "                    \"id\": 80440087,\n" +
                    "                    \"name\": \"天気の子\",\n" +
                    "                    \"artist\": {\n" +
                    "                        \"id\": 0,\n" +
                    "                        \"name\": \"\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    },\n" +
                    "                    \"publishTime\": 1563465600000,\n" +
                    "                    \"size\": 31,\n" +
                    "                    \"copyrightId\": 587012,\n" +
                    "                    \"status\": 1,\n" +
                    "                    \"picId\": 109951164220136540,\n" +
                    "                    \"alia\": [\n" +
                    "                        \"动画电影《天气之子》原声带\"\n" +
                    "                    ],\n" +
                    "                    \"mark\": 0\n" +
                    "                },\n" +
                    "                \"duration\": 184960,\n" +
                    "                \"copyrightId\": 587012,\n" +
                    "                \"status\": 0,\n" +
                    "                \"alias\": [],\n" +
                    "                \"rtype\": 0,\n" +
                    "                \"ftype\": 0,\n" +
                    "                \"mvid\": 0,\n" +
                    "                \"fee\": 1,\n" +
                    "                \"rUrl\": null,\n" +
                    "                \"mark\": 8192\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": 1378491292,\n" +
                    "                \"name\": \"風たちの声 (Movie edit)\",\n" +
                    "                \"artists\": [\n" +
                    "                    {\n" +
                    "                        \"id\": 21132,\n" +
                    "                        \"name\": \"RADWIMPS\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    }\n" +
                    "                ],\n" +
                    "                \"album\": {\n" +
                    "                    \"id\": 80440087,\n" +
                    "                    \"name\": \"天気の子\",\n" +
                    "                    \"artist\": {\n" +
                    "                        \"id\": 0,\n" +
                    "                        \"name\": \"\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    },\n" +
                    "                    \"publishTime\": 1563465600000,\n" +
                    "                    \"size\": 31,\n" +
                    "                    \"copyrightId\": 587012,\n" +
                    "                    \"status\": 1,\n" +
                    "                    \"picId\": 109951164220136540,\n" +
                    "                    \"alia\": [\n" +
                    "                        \"动画电影《天气之子》原声带\"\n" +
                    "                    ],\n" +
                    "                    \"mark\": 0\n" +
                    "                },\n" +
                    "                \"duration\": 157080,\n" +
                    "                \"copyrightId\": 587012,\n" +
                    "                \"status\": 0,\n" +
                    "                \"alias\": [],\n" +
                    "                \"rtype\": 0,\n" +
                    "                \"ftype\": 0,\n" +
                    "                \"mvid\": 0,\n" +
                    "                \"fee\": 1,\n" +
                    "                \"rUrl\": null,\n" +
                    "                \"mark\": 8192\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": 1378492140,\n" +
                    "                \"name\": \"晴れゆく空\",\n" +
                    "                \"artists\": [\n" +
                    "                    {\n" +
                    "                        \"id\": 21132,\n" +
                    "                        \"name\": \"RADWIMPS\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    }\n" +
                    "                ],\n" +
                    "                \"album\": {\n" +
                    "                    \"id\": 80440087,\n" +
                    "                    \"name\": \"天気の子\",\n" +
                    "                    \"artist\": {\n" +
                    "                        \"id\": 0,\n" +
                    "                        \"name\": \"\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    },\n" +
                    "                    \"publishTime\": 1563465600000,\n" +
                    "                    \"size\": 31,\n" +
                    "                    \"copyrightId\": 587012,\n" +
                    "                    \"status\": 1,\n" +
                    "                    \"picId\": 109951164220136540,\n" +
                    "                    \"alia\": [\n" +
                    "                        \"动画电影《天气之子》原声带\"\n" +
                    "                    ],\n" +
                    "                    \"mark\": 0\n" +
                    "                },\n" +
                    "                \"duration\": 133573,\n" +
                    "                \"copyrightId\": 587012,\n" +
                    "                \"status\": 0,\n" +
                    "                \"alias\": [],\n" +
                    "                \"rtype\": 0,\n" +
                    "                \"ftype\": 0,\n" +
                    "                \"mvid\": 0,\n" +
                    "                \"fee\": 1,\n" +
                    "                \"rUrl\": null,\n" +
                    "                \"mark\": 8192\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": 1401055650,\n" +
                    "                \"name\": \"天气之子\",\n" +
                    "                \"artists\": [\n" +
                    "                    {\n" +
                    "                        \"id\": 29397525,\n" +
                    "                        \"name\": \"大先生关海洋\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    }\n" +
                    "                ],\n" +
                    "                \"album\": {\n" +
                    "                    \"id\": 82969736,\n" +
                    "                    \"name\": \"天气之子\",\n" +
                    "                    \"artist\": {\n" +
                    "                        \"id\": 0,\n" +
                    "                        \"name\": \"\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    },\n" +
                    "                    \"publishTime\": 1572853842773,\n" +
                    "                    \"size\": 1,\n" +
                    "                    \"copyrightId\": 0,\n" +
                    "                    \"status\": 0,\n" +
                    "                    \"picId\": 109951164475217860,\n" +
                    "                    \"mark\": 0\n" +
                    "                },\n" +
                    "                \"duration\": 111000,\n" +
                    "                \"copyrightId\": 0,\n" +
                    "                \"status\": 0,\n" +
                    "                \"alias\": [],\n" +
                    "                \"rtype\": 0,\n" +
                    "                \"ftype\": 0,\n" +
                    "                \"mvid\": 0,\n" +
                    "                \"fee\": 0,\n" +
                    "                \"rUrl\": null,\n" +
                    "                \"mark\": 0\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": 1378492144,\n" +
                    "                \"name\": \"陽菜と、走る帆高\",\n" +
                    "                \"artists\": [\n" +
                    "                    {\n" +
                    "                        \"id\": 21132,\n" +
                    "                        \"name\": \"RADWIMPS\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    }\n" +
                    "                ],\n" +
                    "                \"album\": {\n" +
                    "                    \"id\": 80440087,\n" +
                    "                    \"name\": \"天気の子\",\n" +
                    "                    \"artist\": {\n" +
                    "                        \"id\": 0,\n" +
                    "                        \"name\": \"\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    },\n" +
                    "                    \"publishTime\": 1563465600000,\n" +
                    "                    \"size\": 31,\n" +
                    "                    \"copyrightId\": 587012,\n" +
                    "                    \"status\": 1,\n" +
                    "                    \"picId\": 109951164220136540,\n" +
                    "                    \"alia\": [\n" +
                    "                        \"动画电影《天气之子》原声带\"\n" +
                    "                    ],\n" +
                    "                    \"mark\": 0\n" +
                    "                },\n" +
                    "                \"duration\": 143893,\n" +
                    "                \"copyrightId\": 587012,\n" +
                    "                \"status\": 0,\n" +
                    "                \"alias\": [],\n" +
                    "                \"rtype\": 0,\n" +
                    "                \"ftype\": 0,\n" +
                    "                \"mvid\": 0,\n" +
                    "                \"fee\": 1,\n" +
                    "                \"rUrl\": null,\n" +
                    "                \"mark\": 8192\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": 1400596050,\n" +
                    "                \"name\": \"グランドエスケープ 天气之子 男声版（Cover：三浦透子）\",\n" +
                    "                \"artists\": [\n" +
                    "                    {\n" +
                    "                        \"id\": 12319738,\n" +
                    "                        \"name\": \"悠\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    }\n" +
                    "                ],\n" +
                    "                \"album\": {\n" +
                    "                    \"id\": 82881202,\n" +
                    "                    \"name\": \"グランドエスケープ\",\n" +
                    "                    \"artist\": {\n" +
                    "                        \"id\": 0,\n" +
                    "                        \"name\": \"\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    },\n" +
                    "                    \"publishTime\": 1572661009034,\n" +
                    "                    \"size\": 1,\n" +
                    "                    \"copyrightId\": 0,\n" +
                    "                    \"status\": 0,\n" +
                    "                    \"picId\": 109951164463012900,\n" +
                    "                    \"mark\": 0\n" +
                    "                },\n" +
                    "                \"duration\": 190033,\n" +
                    "                \"copyrightId\": 0,\n" +
                    "                \"status\": 0,\n" +
                    "                \"alias\": [],\n" +
                    "                \"rtype\": 0,\n" +
                    "                \"ftype\": 0,\n" +
                    "                \"mvid\": 0,\n" +
                    "                \"fee\": 0,\n" +
                    "                \"rUrl\": null,\n" +
                    "                \"mark\": 0\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": 1371858115,\n" +
                    "                \"name\": \"天气之子\",\n" +
                    "                \"artists\": [\n" +
                    "                    {\n" +
                    "                        \"id\": 12936164,\n" +
                    "                        \"name\": \"王畅\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    }\n" +
                    "                ],\n" +
                    "                \"album\": {\n" +
                    "                    \"id\": 79698530,\n" +
                    "                    \"name\": \"天气之子（新海诚）\",\n" +
                    "                    \"artist\": {\n" +
                    "                        \"id\": 0,\n" +
                    "                        \"name\": \"\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    },\n" +
                    "                    \"publishTime\": 1560528321240,\n" +
                    "                    \"size\": 1,\n" +
                    "                    \"copyrightId\": 0,\n" +
                    "                    \"status\": 0,\n" +
                    "                    \"picId\": 109951164494558670,\n" +
                    "                    \"mark\": 0\n" +
                    "                },\n" +
                    "                \"duration\": 241743,\n" +
                    "                \"copyrightId\": 0,\n" +
                    "                \"status\": 0,\n" +
                    "                \"alias\": [],\n" +
                    "                \"rtype\": 0,\n" +
                    "                \"ftype\": 0,\n" +
                    "                \"mvid\": 10873634,\n" +
                    "                \"fee\": 0,\n" +
                    "                \"rUrl\": null,\n" +
                    "                \"mark\": 0\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": 1378491284,\n" +
                    "                \"name\": \"ふたたびの、雨\",\n" +
                    "                \"artists\": [\n" +
                    "                    {\n" +
                    "                        \"id\": 21132,\n" +
                    "                        \"name\": \"RADWIMPS\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    }\n" +
                    "                ],\n" +
                    "                \"album\": {\n" +
                    "                    \"id\": 80440087,\n" +
                    "                    \"name\": \"天気の子\",\n" +
                    "                    \"artist\": {\n" +
                    "                        \"id\": 0,\n" +
                    "                        \"name\": \"\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    },\n" +
                    "                    \"publishTime\": 1563465600000,\n" +
                    "                    \"size\": 31,\n" +
                    "                    \"copyrightId\": 587012,\n" +
                    "                    \"status\": 1,\n" +
                    "                    \"picId\": 109951164220136540,\n" +
                    "                    \"alia\": [\n" +
                    "                        \"动画电影《天气之子》原声带\"\n" +
                    "                    ],\n" +
                    "                    \"mark\": 0\n" +
                    "                },\n" +
                    "                \"duration\": 44586,\n" +
                    "                \"copyrightId\": 587012,\n" +
                    "                \"status\": 0,\n" +
                    "                \"alias\": [],\n" +
                    "                \"rtype\": 0,\n" +
                    "                \"ftype\": 0,\n" +
                    "                \"mvid\": 0,\n" +
                    "                \"fee\": 1,\n" +
                    "                \"rUrl\": null,\n" +
                    "                \"mark\": 8192\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": 1378491288,\n" +
                    "                \"name\": \"消えゆく陽菜\",\n" +
                    "                \"artists\": [\n" +
                    "                    {\n" +
                    "                        \"id\": 21132,\n" +
                    "                        \"name\": \"RADWIMPS\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    }\n" +
                    "                ],\n" +
                    "                \"album\": {\n" +
                    "                    \"id\": 80440087,\n" +
                    "                    \"name\": \"天気の子\",\n" +
                    "                    \"artist\": {\n" +
                    "                        \"id\": 0,\n" +
                    "                        \"name\": \"\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    },\n" +
                    "                    \"publishTime\": 1563465600000,\n" +
                    "                    \"size\": 31,\n" +
                    "                    \"copyrightId\": 587012,\n" +
                    "                    \"status\": 1,\n" +
                    "                    \"picId\": 109951164220136540,\n" +
                    "                    \"alia\": [\n" +
                    "                        \"动画电影《天气之子》原声带\"\n" +
                    "                    ],\n" +
                    "                    \"mark\": 0\n" +
                    "                },\n" +
                    "                \"duration\": 68053,\n" +
                    "                \"copyrightId\": 587012,\n" +
                    "                \"status\": 0,\n" +
                    "                \"alias\": [],\n" +
                    "                \"rtype\": 0,\n" +
                    "                \"ftype\": 0,\n" +
                    "                \"mvid\": 0,\n" +
                    "                \"fee\": 1,\n" +
                    "                \"rUrl\": null,\n" +
                    "                \"mark\": 8192\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": 1378491290,\n" +
                    "                \"name\": \"二つの告白\",\n" +
                    "                \"artists\": [\n" +
                    "                    {\n" +
                    "                        \"id\": 21132,\n" +
                    "                        \"name\": \"RADWIMPS\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    }\n" +
                    "                ],\n" +
                    "                \"album\": {\n" +
                    "                    \"id\": 80440087,\n" +
                    "                    \"name\": \"天気の子\",\n" +
                    "                    \"artist\": {\n" +
                    "                        \"id\": 0,\n" +
                    "                        \"name\": \"\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    },\n" +
                    "                    \"publishTime\": 1563465600000,\n" +
                    "                    \"size\": 31,\n" +
                    "                    \"copyrightId\": 587012,\n" +
                    "                    \"status\": 1,\n" +
                    "                    \"picId\": 109951164220136540,\n" +
                    "                    \"alia\": [\n" +
                    "                        \"动画电影《天气之子》原声带\"\n" +
                    "                    ],\n" +
                    "                    \"mark\": 0\n" +
                    "                },\n" +
                    "                \"duration\": 96666,\n" +
                    "                \"copyrightId\": 587012,\n" +
                    "                \"status\": 0,\n" +
                    "                \"alias\": [],\n" +
                    "                \"rtype\": 0,\n" +
                    "                \"ftype\": 0,\n" +
                    "                \"mvid\": 0,\n" +
                    "                \"fee\": 1,\n" +
                    "                \"rUrl\": null,\n" +
                    "                \"mark\": 8192\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": 1378492137,\n" +
                    "                \"name\": \"初の晴れ女バイト\",\n" +
                    "                \"artists\": [\n" +
                    "                    {\n" +
                    "                        \"id\": 21132,\n" +
                    "                        \"name\": \"RADWIMPS\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    }\n" +
                    "                ],\n" +
                    "                \"album\": {\n" +
                    "                    \"id\": 80440087,\n" +
                    "                    \"name\": \"天気の子\",\n" +
                    "                    \"artist\": {\n" +
                    "                        \"id\": 0,\n" +
                    "                        \"name\": \"\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    },\n" +
                    "                    \"publishTime\": 1563465600000,\n" +
                    "                    \"size\": 31,\n" +
                    "                    \"copyrightId\": 587012,\n" +
                    "                    \"status\": 1,\n" +
                    "                    \"picId\": 109951164220136540,\n" +
                    "                    \"alia\": [\n" +
                    "                        \"动画电影《天气之子》原声带\"\n" +
                    "                    ],\n" +
                    "                    \"mark\": 0\n" +
                    "                },\n" +
                    "                \"duration\": 79786,\n" +
                    "                \"copyrightId\": 587012,\n" +
                    "                \"status\": 0,\n" +
                    "                \"alias\": [],\n" +
                    "                \"rtype\": 0,\n" +
                    "                \"ftype\": 0,\n" +
                    "                \"mvid\": 0,\n" +
                    "                \"fee\": 1,\n" +
                    "                \"rUrl\": null,\n" +
                    "                \"mark\": 8192\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": 1378492134,\n" +
                    "                \"name\": \"『天気の子』のテーマ\",\n" +
                    "                \"artists\": [\n" +
                    "                    {\n" +
                    "                        \"id\": 21132,\n" +
                    "                        \"name\": \"RADWIMPS\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    }\n" +
                    "                ],\n" +
                    "                \"album\": {\n" +
                    "                    \"id\": 80440087,\n" +
                    "                    \"name\": \"天気の子\",\n" +
                    "                    \"artist\": {\n" +
                    "                        \"id\": 0,\n" +
                    "                        \"name\": \"\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    },\n" +
                    "                    \"publishTime\": 1563465600000,\n" +
                    "                    \"size\": 31,\n" +
                    "                    \"copyrightId\": 587012,\n" +
                    "                    \"status\": 1,\n" +
                    "                    \"picId\": 109951164220136540,\n" +
                    "                    \"alia\": [\n" +
                    "                        \"动画电影《天气之子》原声带\"\n" +
                    "                    ],\n" +
                    "                    \"mark\": 0\n" +
                    "                },\n" +
                    "                \"duration\": 41733,\n" +
                    "                \"copyrightId\": 587012,\n" +
                    "                \"status\": 0,\n" +
                    "                \"alias\": [],\n" +
                    "                \"rtype\": 0,\n" +
                    "                \"ftype\": 0,\n" +
                    "                \"mvid\": 0,\n" +
                    "                \"fee\": 1,\n" +
                    "                \"rUrl\": null,\n" +
                    "                \"mark\": 8192\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": 1378491294,\n" +
                    "                \"name\": \"家族の時間\",\n" +
                    "                \"artists\": [\n" +
                    "                    {\n" +
                    "                        \"id\": 21132,\n" +
                    "                        \"name\": \"RADWIMPS\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    }\n" +
                    "                ],\n" +
                    "                \"album\": {\n" +
                    "                    \"id\": 80440087,\n" +
                    "                    \"name\": \"天気の子\",\n" +
                    "                    \"artist\": {\n" +
                    "                        \"id\": 0,\n" +
                    "                        \"name\": \"\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    },\n" +
                    "                    \"publishTime\": 1563465600000,\n" +
                    "                    \"size\": 31,\n" +
                    "                    \"copyrightId\": 587012,\n" +
                    "                    \"status\": 1,\n" +
                    "                    \"picId\": 109951164220136540,\n" +
                    "                    \"alia\": [\n" +
                    "                        \"动画电影《天气之子》原声带\"\n" +
                    "                    ],\n" +
                    "                    \"mark\": 0\n" +
                    "                },\n" +
                    "                \"duration\": 153333,\n" +
                    "                \"copyrightId\": 587012,\n" +
                    "                \"status\": 0,\n" +
                    "                \"alias\": [],\n" +
                    "                \"rtype\": 0,\n" +
                    "                \"ftype\": 0,\n" +
                    "                \"mvid\": 0,\n" +
                    "                \"fee\": 1,\n" +
                    "                \"rUrl\": null,\n" +
                    "                \"mark\": 8192\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": 1378491289,\n" +
                    "                \"name\": \"陽菜、救出\",\n" +
                    "                \"artists\": [\n" +
                    "                    {\n" +
                    "                        \"id\": 21132,\n" +
                    "                        \"name\": \"RADWIMPS\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    }\n" +
                    "                ],\n" +
                    "                \"album\": {\n" +
                    "                    \"id\": 80440087,\n" +
                    "                    \"name\": \"天気の子\",\n" +
                    "                    \"artist\": {\n" +
                    "                        \"id\": 0,\n" +
                    "                        \"name\": \"\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    },\n" +
                    "                    \"publishTime\": 1563465600000,\n" +
                    "                    \"size\": 31,\n" +
                    "                    \"copyrightId\": 587012,\n" +
                    "                    \"status\": 1,\n" +
                    "                    \"picId\": 109951164220136540,\n" +
                    "                    \"alia\": [\n" +
                    "                        \"动画电影《天气之子》原声带\"\n" +
                    "                    ],\n" +
                    "                    \"mark\": 0\n" +
                    "                },\n" +
                    "                \"duration\": 107826,\n" +
                    "                \"copyrightId\": 587012,\n" +
                    "                \"status\": 0,\n" +
                    "                \"alias\": [],\n" +
                    "                \"rtype\": 0,\n" +
                    "                \"ftype\": 0,\n" +
                    "                \"mvid\": 0,\n" +
                    "                \"fee\": 1,\n" +
                    "                \"rUrl\": null,\n" +
                    "                \"mark\": 8192\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": 1378492139,\n" +
                    "                \"name\": \"首都危機\",\n" +
                    "                \"artists\": [\n" +
                    "                    {\n" +
                    "                        \"id\": 21132,\n" +
                    "                        \"name\": \"RADWIMPS\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    }\n" +
                    "                ],\n" +
                    "                \"album\": {\n" +
                    "                    \"id\": 80440087,\n" +
                    "                    \"name\": \"天気の子\",\n" +
                    "                    \"artist\": {\n" +
                    "                        \"id\": 0,\n" +
                    "                        \"name\": \"\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    },\n" +
                    "                    \"publishTime\": 1563465600000,\n" +
                    "                    \"size\": 31,\n" +
                    "                    \"copyrightId\": 587012,\n" +
                    "                    \"status\": 1,\n" +
                    "                    \"picId\": 109951164220136540,\n" +
                    "                    \"alia\": [\n" +
                    "                        \"动画电影《天气之子》原声带\"\n" +
                    "                    ],\n" +
                    "                    \"mark\": 0\n" +
                    "                },\n" +
                    "                \"duration\": 97040,\n" +
                    "                \"copyrightId\": 587012,\n" +
                    "                \"status\": 0,\n" +
                    "                \"alias\": [],\n" +
                    "                \"rtype\": 0,\n" +
                    "                \"ftype\": 0,\n" +
                    "                \"mvid\": 0,\n" +
                    "                \"fee\": 1,\n" +
                    "                \"rUrl\": null,\n" +
                    "                \"mark\": 8192\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": 1380625694,\n" +
                    "                \"name\": \"天气之子（Weathering with you）\",\n" +
                    "                \"artists\": [\n" +
                    "                    {\n" +
                    "                        \"id\": 12568511,\n" +
                    "                        \"name\": \"果果\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    }\n" +
                    "                ],\n" +
                    "                \"album\": {\n" +
                    "                    \"id\": 80562583,\n" +
                    "                    \"name\": \"22.5\",\n" +
                    "                    \"artist\": {\n" +
                    "                        \"id\": 0,\n" +
                    "                        \"name\": \"\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    },\n" +
                    "                    \"publishTime\": 1564243200000,\n" +
                    "                    \"size\": 7,\n" +
                    "                    \"copyrightId\": 0,\n" +
                    "                    \"status\": 0,\n" +
                    "                    \"picId\": 109951164241922000,\n" +
                    "                    \"mark\": 0\n" +
                    "                },\n" +
                    "                \"duration\": 207960,\n" +
                    "                \"copyrightId\": 0,\n" +
                    "                \"status\": 0,\n" +
                    "                \"alias\": [],\n" +
                    "                \"rtype\": 0,\n" +
                    "                \"ftype\": 0,\n" +
                    "                \"mvid\": 0,\n" +
                    "                \"fee\": 8,\n" +
                    "                \"rUrl\": null,\n" +
                    "                \"mark\": 0\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": 1401340239,\n" +
                    "                \"name\": \"RADWIMPS-天气之子BGM——愛にできることはまだあるかい（remix）（小因index Remix）\",\n" +
                    "                \"artists\": [\n" +
                    "                    {\n" +
                    "                        \"id\": 12167111,\n" +
                    "                        \"name\": \"小因index\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    }\n" +
                    "                ],\n" +
                    "                \"album\": {\n" +
                    "                    \"id\": 80883845,\n" +
                    "                    \"name\": \"一团小因翻唱基地\",\n" +
                    "                    \"artist\": {\n" +
                    "                        \"id\": 0,\n" +
                    "                        \"name\": \"\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    },\n" +
                    "                    \"publishTime\": 1565528396776,\n" +
                    "                    \"size\": 5,\n" +
                    "                    \"copyrightId\": 0,\n" +
                    "                    \"status\": 0,\n" +
                    "                    \"picId\": 109951164285159870,\n" +
                    "                    \"mark\": 0\n" +
                    "                },\n" +
                    "                \"duration\": 250096,\n" +
                    "                \"copyrightId\": 0,\n" +
                    "                \"status\": 0,\n" +
                    "                \"alias\": [],\n" +
                    "                \"rtype\": 0,\n" +
                    "                \"ftype\": 0,\n" +
                    "                \"mvid\": 0,\n" +
                    "                \"fee\": 0,\n" +
                    "                \"rUrl\": null,\n" +
                    "                \"mark\": 0\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": 1378491287,\n" +
                    "                \"name\": \"天気の力\",\n" +
                    "                \"artists\": [\n" +
                    "                    {\n" +
                    "                        \"id\": 21132,\n" +
                    "                        \"name\": \"RADWIMPS\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    }\n" +
                    "                ],\n" +
                    "                \"album\": {\n" +
                    "                    \"id\": 80440087,\n" +
                    "                    \"name\": \"天気の子\",\n" +
                    "                    \"artist\": {\n" +
                    "                        \"id\": 0,\n" +
                    "                        \"name\": \"\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    },\n" +
                    "                    \"publishTime\": 1563465600000,\n" +
                    "                    \"size\": 31,\n" +
                    "                    \"copyrightId\": 587012,\n" +
                    "                    \"status\": 1,\n" +
                    "                    \"picId\": 109951164220136540,\n" +
                    "                    \"alia\": [\n" +
                    "                        \"动画电影《天气之子》原声带\"\n" +
                    "                    ],\n" +
                    "                    \"mark\": 0\n" +
                    "                },\n" +
                    "                \"duration\": 82680,\n" +
                    "                \"copyrightId\": 587012,\n" +
                    "                \"status\": 0,\n" +
                    "                \"alias\": [],\n" +
                    "                \"rtype\": 0,\n" +
                    "                \"ftype\": 0,\n" +
                    "                \"mvid\": 0,\n" +
                    "                \"fee\": 1,\n" +
                    "                \"rUrl\": null,\n" +
                    "                \"mark\": 8192\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": 1378492132,\n" +
                    "                \"name\": \"優しさの味\",\n" +
                    "                \"artists\": [\n" +
                    "                    {\n" +
                    "                        \"id\": 21132,\n" +
                    "                        \"name\": \"RADWIMPS\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    }\n" +
                    "                ],\n" +
                    "                \"album\": {\n" +
                    "                    \"id\": 80440087,\n" +
                    "                    \"name\": \"天気の子\",\n" +
                    "                    \"artist\": {\n" +
                    "                        \"id\": 0,\n" +
                    "                        \"name\": \"\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    },\n" +
                    "                    \"publishTime\": 1563465600000,\n" +
                    "                    \"size\": 31,\n" +
                    "                    \"copyrightId\": 587012,\n" +
                    "                    \"status\": 1,\n" +
                    "                    \"picId\": 109951164220136540,\n" +
                    "                    \"alia\": [\n" +
                    "                        \"动画电影《天气之子》原声带\"\n" +
                    "                    ],\n" +
                    "                    \"mark\": 0\n" +
                    "                },\n" +
                    "                \"duration\": 48866,\n" +
                    "                \"copyrightId\": 587012,\n" +
                    "                \"status\": 0,\n" +
                    "                \"alias\": [],\n" +
                    "                \"rtype\": 0,\n" +
                    "                \"ftype\": 0,\n" +
                    "                \"mvid\": 0,\n" +
                    "                \"fee\": 1,\n" +
                    "                \"rUrl\": null,\n" +
                    "                \"mark\": 8192\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": 1378491295,\n" +
                    "                \"name\": \"晴天と喪失\",\n" +
                    "                \"artists\": [\n" +
                    "                    {\n" +
                    "                        \"id\": 21132,\n" +
                    "                        \"name\": \"RADWIMPS\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    }\n" +
                    "                ],\n" +
                    "                \"album\": {\n" +
                    "                    \"id\": 80440087,\n" +
                    "                    \"name\": \"天気の子\",\n" +
                    "                    \"artist\": {\n" +
                    "                        \"id\": 0,\n" +
                    "                        \"name\": \"\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p2.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    },\n" +
                    "                    \"publishTime\": 1563465600000,\n" +
                    "                    \"size\": 31,\n" +
                    "                    \"copyrightId\": 587012,\n" +
                    "                    \"status\": 1,\n" +
                    "                    \"picId\": 109951164220136540,\n" +
                    "                    \"alia\": [\n" +
                    "                        \"动画电影《天气之子》原声带\"\n" +
                    "                    ],\n" +
                    "                    \"mark\": 0\n" +
                    "                },\n" +
                    "                \"duration\": 165293,\n" +
                    "                \"copyrightId\": 587012,\n" +
                    "                \"status\": 0,\n" +
                    "                \"alias\": [],\n" +
                    "                \"rtype\": 0,\n" +
                    "                \"ftype\": 0,\n" +
                    "                \"mvid\": 0,\n" +
                    "                \"fee\": 1,\n" +
                    "                \"rUrl\": null,\n" +
                    "                \"mark\": 8192\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": 1401025135,\n" +
                    "                \"name\": \"グランドエスケープ feat.三浦透子\",\n" +
                    "                \"artists\": [\n" +
                    "                    {\n" +
                    "                        \"id\": 21132,\n" +
                    "                        \"name\": \"RADWIMPS\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    },\n" +
                    "                    {\n" +
                    "                        \"id\": 32664726,\n" +
                    "                        \"name\": \"三浦透子\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    }\n" +
                    "                ],\n" +
                    "                \"album\": {\n" +
                    "                    \"id\": 82894738,\n" +
                    "                    \"name\": \"天気の子 complete version\",\n" +
                    "                    \"artist\": {\n" +
                    "                        \"id\": 0,\n" +
                    "                        \"name\": \"\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    },\n" +
                    "                    \"publishTime\": 1574784000000,\n" +
                    "                    \"size\": 6,\n" +
                    "                    \"copyrightId\": 587012,\n" +
                    "                    \"status\": 0,\n" +
                    "                    \"picId\": 109951164459591380,\n" +
                    "                    \"mark\": 0\n" +
                    "                },\n" +
                    "                \"duration\": 339160,\n" +
                    "                \"copyrightId\": 587012,\n" +
                    "                \"status\": 0,\n" +
                    "                \"alias\": [\n" +
                    "                    \"动画电影《天气之子》主题曲\"\n" +
                    "                ],\n" +
                    "                \"rtype\": 0,\n" +
                    "                \"ftype\": 0,\n" +
                    "                \"mvid\": 10904116,\n" +
                    "                \"fee\": 4,\n" +
                    "                \"rUrl\": null,\n" +
                    "                \"mark\": 0\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": 1401024455,\n" +
                    "                \"name\": \"愛にできることはまだあるかい\",\n" +
                    "                \"artists\": [\n" +
                    "                    {\n" +
                    "                        \"id\": 21132,\n" +
                    "                        \"name\": \"RADWIMPS\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    }\n" +
                    "                ],\n" +
                    "                \"album\": {\n" +
                    "                    \"id\": 82894738,\n" +
                    "                    \"name\": \"天気の子 complete version\",\n" +
                    "                    \"artist\": {\n" +
                    "                        \"id\": 0,\n" +
                    "                        \"name\": \"\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    },\n" +
                    "                    \"publishTime\": 1574784000000,\n" +
                    "                    \"size\": 6,\n" +
                    "                    \"copyrightId\": 587012,\n" +
                    "                    \"status\": 0,\n" +
                    "                    \"picId\": 109951164459591380,\n" +
                    "                    \"mark\": 0\n" +
                    "                },\n" +
                    "                \"duration\": 414373,\n" +
                    "                \"copyrightId\": 587012,\n" +
                    "                \"status\": 0,\n" +
                    "                \"alias\": [\n" +
                    "                    \"动画电影《天气之子》主题曲\"\n" +
                    "                ],\n" +
                    "                \"rtype\": 0,\n" +
                    "                \"ftype\": 0,\n" +
                    "                \"mvid\": 10904114,\n" +
                    "                \"fee\": 4,\n" +
                    "                \"rUrl\": null,\n" +
                    "                \"mark\": 0\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": 1388668780,\n" +
                    "                \"name\": \"天气之子 三叶的回忆\",\n" +
                    "                \"artists\": [\n" +
                    "                    {\n" +
                    "                        \"id\": 31724905,\n" +
                    "                        \"name\": \"杰西\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    }\n" +
                    "                ],\n" +
                    "                \"album\": {\n" +
                    "                    \"id\": 81307058,\n" +
                    "                    \"name\": \"天气之子 三叶的回忆\",\n" +
                    "                    \"artist\": {\n" +
                    "                        \"id\": 0,\n" +
                    "                        \"name\": \"\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    },\n" +
                    "                    \"publishTime\": 1567608137214,\n" +
                    "                    \"size\": 1,\n" +
                    "                    \"copyrightId\": 0,\n" +
                    "                    \"status\": 0,\n" +
                    "                    \"picId\": 109951164344072560,\n" +
                    "                    \"mark\": 0\n" +
                    "                },\n" +
                    "                \"duration\": 33230,\n" +
                    "                \"copyrightId\": 0,\n" +
                    "                \"status\": 0,\n" +
                    "                \"alias\": [],\n" +
                    "                \"rtype\": 0,\n" +
                    "                \"ftype\": 0,\n" +
                    "                \"mvid\": 0,\n" +
                    "                \"fee\": 8,\n" +
                    "                \"rUrl\": null,\n" +
                    "                \"mark\": 0\n" +
                    "            },\n" +
                    "            {\n" +
                    "                \"id\": 1401025126,\n" +
                    "                \"name\": \"風たちの声\",\n" +
                    "                \"artists\": [\n" +
                    "                    {\n" +
                    "                        \"id\": 21132,\n" +
                    "                        \"name\": \"RADWIMPS\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    }\n" +
                    "                ],\n" +
                    "                \"album\": {\n" +
                    "                    \"id\": 82894738,\n" +
                    "                    \"name\": \"天気の子 complete version\",\n" +
                    "                    \"artist\": {\n" +
                    "                        \"id\": 0,\n" +
                    "                        \"name\": \"\",\n" +
                    "                        \"picUrl\": null,\n" +
                    "                        \"alias\": [],\n" +
                    "                        \"albumSize\": 0,\n" +
                    "                        \"picId\": 0,\n" +
                    "                        \"img1v1Url\": \"https://p1.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg\",\n" +
                    "                        \"img1v1\": 0,\n" +
                    "                        \"trans\": null\n" +
                    "                    },\n" +
                    "                    \"publishTime\": 1574784000000,\n" +
                    "                    \"size\": 6,\n" +
                    "                    \"copyrightId\": 587012,\n" +
                    "                    \"status\": 0,\n" +
                    "                    \"picId\": 109951164459591380,\n" +
                    "                    \"mark\": 0\n" +
                    "                },\n" +
                    "                \"duration\": 253373,\n" +
                    "                \"copyrightId\": 587012,\n" +
                    "                \"status\": 0,\n" +
                    "                \"alias\": [\n" +
                    "                    \"动画电影《天气之子》主题曲\"\n" +
                    "                ],\n" +
                    "                \"rtype\": 0,\n" +
                    "                \"ftype\": 0,\n" +
                    "                \"mvid\": 0,\n" +
                    "                \"fee\": 4,\n" +
                    "                \"rUrl\": null,\n" +
                    "                \"mark\": 0\n" +
                    "            }\n" +
                    "        ],\n" +
                    "        \"songCount\": 127\n" +
                    "    },\n" +
                    "    \"code\": 200\n" +
                    "}";
        }
    }

}
