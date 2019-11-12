package com.example.demo.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "User")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class User {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String uid;

    @Column(name="userName",length = 200)
    private String userName;

    @Column(name="passWord",length = 200)
    private String passWord;

    @Column(name="sex")
    private Integer sex;  ///1为男性 2为女性

    @Column(name = "phone")
    private String phone;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                '}';
    }
}
