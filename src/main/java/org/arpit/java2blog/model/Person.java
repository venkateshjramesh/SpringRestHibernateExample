package org.arpit.java2blog.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by rameve02 on 28-04-2017.
 */
@Entity
@Table(name="person")
public class Person {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;

    @Column(name="name")
    String name;

    @Column(name="age")
    Integer age;

    @Column(name="email")
    String email;

    @Column(name="mobile")
    String mobile;

    @Column(name="viewName")
    String viewName;


    @Column(name="modifiedDate")
    Date modifiedDate;

    @Column(name="createdDate")
    Date createdDate;

    public Person() {
        super();
    }

    public Person(Integer id, String name, Integer age, String email, String mobile, String viewName, Date modifiedDate, Date createdDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.mobile = mobile;
        this.viewName = viewName;
        this.modifiedDate = modifiedDate;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
