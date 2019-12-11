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

    @Column(name = "studentNumber", length = 200)
    private String studentNumber;

    @Column(name = "username", length = 200)
    private String username;

    @Column(name = "passWord", length = 200)
    private String passWord;


    ///邮箱
    @Column(name = "email", length = 200)
    private String email;


    ///电话
    @Column(name = "phone", length = 200)
    private String phone;

    ///城市
    @Column(name = "city", length = 200)
    private String city;

    ///签名
    @Column(name = "sign", length = 200)
    private String sign;

    ///职业
    @Column(name = "classify", length = 200)
    private String classify;

    ///财富
    @Column(name = "wealth", length = 200)
    private String wealth;

    @Column(name = "sex")
    private String sex;  ///1为男性 2为女性

    public User() {
    }


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getWealth() {
        return wealth;
    }

    public void setWealth(String wealth) {
        this.wealth = wealth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", username='" + username + '\'' +
                ", passWord='" + passWord + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                ", sign='" + sign + '\'' +
                ", classify='" + classify + '\'' +
                ", wealth='" + wealth + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
