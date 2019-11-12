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

}
