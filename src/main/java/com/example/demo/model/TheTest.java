package com.example.demo.model;


import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;


@Entity
@Table(name = "TheTest")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class TheTest {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String uid;


    ///考试名字
    @Column(name="theName",length = 200)
    private String theName;

    ///考试开始时间
    @Column(name = "theStartTime" ,length = 200)
    private String theStartTime;

    ///考试结束时间
    @Column(name = "theEndOfTime" ,length = 200)
    private String theEndOfTime;

    ///考试的试卷ID
    @Column(name = "TestPaperID" ,length = 200)
    private String TestPaperID;

    ///考试状态
    @Column(name = "State" ,length = 200)
    private String State;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTheName() {
        return theName;
    }

    public void setTheName(String theName) {
        this.theName = theName;
    }

    public String getTheStartTime() {
        return theStartTime;
    }

    public void setTheStartTime(String theStartTime) {
        this.theStartTime = theStartTime;
    }

    public String getTheEndOfTime() {
        return theEndOfTime;
    }

    public void setTheEndOfTime(String theEndOfTime) {
        this.theEndOfTime = theEndOfTime;
    }

    public String getTestPaperID() {
        return TestPaperID;
    }

    public void setTestPaperID(String testPaperID) {
        TestPaperID = testPaperID;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }
}
