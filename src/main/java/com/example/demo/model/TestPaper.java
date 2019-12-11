package com.example.demo.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "testpager")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class TestPaper {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String uid;


    ///试卷编号
    @Column(name="tid",length = 200)
    private String tid;

    ///试卷的名字
    @Column(name = "tname" ,length = 200)
    private  String tname;

    ///介绍
    @Column(name = "introduce" ,length = 500)
    private  String introduce;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Override
    public String toString() {
        return "TestPaper{" +
                "uid='" + uid + '\'' +
                ", tid='" + tid + '\'' +
                ", tname='" + tname + '\'' +
                ", introduce='" + introduce + '\'' +
                '}';
    }
}
