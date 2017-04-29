package org.arpit.java2blog.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by rameve02 on 28-04-2017.
 */
@Entity
@Table(name="static_bet_type")
public class StaticBetType {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;

    @Column(name="rule")
    String rule;

    @Column(name="displayName")
    String displayName;

    @Column(name="betType")
    String betType;


    @Column(name="modifiedDate")
    Date modifiedDate;

    @Column(name="createdDate")
    Date createdDate;

    public StaticBetType() {
        super();
    }

    public StaticBetType(Integer id, String rule, String displayName, String betType, Date modifiedDate, Date createdDate) {
        this.id = id;
        this.rule = rule;
        this.displayName = displayName;
        this.betType = betType;
        this.modifiedDate = modifiedDate;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getBetType() {
        return betType;
    }

    public void setBetType(String betType) {
        this.betType = betType;
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
