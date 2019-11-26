package com.example.demo.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "exercise")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Exercise {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String uid;

    ///试卷id
    @Column(name="sid",length = 200)
    private String sid;

    ///习题id
    @Column(name="tid",length = 200)
    private String tid;

    ///问题
    @Column(name="question",length = 200)
    private String question;

    ///答案
    @Column(name="answer",length = 200)
    private String answer;

    @Column(name="item1",length = 200)
    private String item1;

    @Column(name="item2",length = 200)
    private String item2;

    @Column(name="item3",length = 200)
    private String item3;

    @Column(name="item4",length = 200)
    private String item4;

    ///解析
    @Column(name="explains",length = 200)
    private String explains;


    @Column(name="url",length = 200)
    private String url;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getItem1() {
        return item1;
    }

    public void setItem1(String item1) {
        this.item1 = item1;
    }

    public String getItem2() {
        return item2;
    }

    public void setItem2(String item2) {
        this.item2 = item2;
    }

    public String getItem3() {
        return item3;
    }

    public void setItem3(String item3) {
        this.item3 = item3;
    }

    public String getItem4() {
        return item4;
    }

    public void setItem4(String item4) {
        this.item4 = item4;
    }

    public String getExplains() {
        return explains;
    }

    public void setExplains(String explains) {
        this.explains = explains;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "uid='" + uid + '\'' +
                ", sid='" + sid + '\'' +
                ", tid='" + tid + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", item1='" + item1 + '\'' +
                ", item2='" + item2 + '\'' +
                ", item3='" + item3 + '\'' +
                ", item4='" + item4 + '\'' +
                ", explains='" + explains + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
