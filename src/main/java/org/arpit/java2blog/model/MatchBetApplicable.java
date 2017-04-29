package org.arpit.java2blog.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by rameve02 on 28-04-2017.
 */
@Entity
@Table(name="match_bet_applicable")
public class MatchBetApplicable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "staticBetId")
    StaticBetType staticBetType;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "matchId")
    Match match;

    @Column(name="modifiedDate")
    Date modifiedDate;

    @Column(name="createdDate")
    Date createdDate;

    @Column(name="status")
    String status;

    @Column(name="percentage")
    Float percentage;

    @Column(name="value")
    Float value;

    public MatchBetApplicable() {
        super();
    }

    public MatchBetApplicable(Integer id, StaticBetType staticBetType, Match match, Date modifiedDate, Date createdDate, Float percentage, Float value) {
        this.id = id;
        this.staticBetType = staticBetType;
        this.match = match;
        this.modifiedDate = modifiedDate;
        this.createdDate = createdDate;
        this.percentage = percentage;
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StaticBetType getStaticBetType() {
        return staticBetType;
    }

    public void setStaticBetType(StaticBetType staticBetType) {
        this.staticBetType = staticBetType;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
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

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
}
