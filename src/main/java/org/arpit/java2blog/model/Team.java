package org.arpit.java2blog.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by rameve02 on 28-04-2017.
 */
@Entity
@Table(name="TEAM")
public class Team {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;

    @Column(name="name")
    String name;

    @Column(name="photoId")
    String photoId;

    @Column(name="description")
    String description;

    @Column(name="viewName")
    String viewName;

    @Column(name="createdDate")
    Date createdDate;

    @Column(name="modifiedDate")
    Date modifiedDate;


    public Team(Integer id, String name, String photoId, String description, String viewName, Date createdDate, Date modifiedDate) {
        this.id = id;
        this.name = name;
        this.photoId = photoId;
        this.description = description;
        this.viewName = viewName;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public Team(){
        super();
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

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
