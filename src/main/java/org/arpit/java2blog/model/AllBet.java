package org.arpit.java2blog.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by rameve02 on 28-04-2017.
 */
@Entity
@Table(name="all_bet")
public class AllBet {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;


    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "playerId")
    Player player;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "matchId")
    Match match;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "teamId")
    Team team;

    @OneToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "personId")
    Person person;

    @Column(name="modifiedDate")
    Date modifiedDate;

    @Column(name="createdDate")
    Date createdDate;

    @Column(name="runs")
    Integer runs;

    @Column(name="over")
    Float over;

    @Column(name="ball")
    Float ball;

    @Column(name="amount")
    Long amount;

    @OneToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="staticBetRuleId")
    MatchBetApplicable matchBetApplicable;


    @Column(name="status")
    String status;

    public AllBet(Integer id, Player player, Match match, Team team, Person person, Date modifiedDate, Date createdDate, Integer runs, Float over, Float ball, Long amount, MatchBetApplicable matchBetApplicable, String status) {
        this.id = id;
        this.player = player;
        this.match = match;
        this.team = team;
        this.person = person;
        this.modifiedDate = modifiedDate;
        this.createdDate = createdDate;
        this.runs = runs;
        this.over = over;
        this.ball = ball;
        this.amount = amount;
        this.matchBetApplicable = matchBetApplicable;
        this.status = status;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public AllBet() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
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

    public Integer getRuns() {
        return runs;
    }

    public void setRuns(Integer runs) {
        this.runs = runs;
    }

    public Float getOver() {
        return over;
    }

    public void setOver(Float over) {
        this.over = over;
    }

    public Float getBall() {
        return ball;
    }

    public void setBall(Float ball) {
        this.ball = ball;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public MatchBetApplicable getMatchBetApplicable() {
        return matchBetApplicable;
    }

    public void setMatchBetApplicable(MatchBetApplicable matchBetApplicable) {
        this.matchBetApplicable = matchBetApplicable;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
