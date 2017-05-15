package org.arpit.java2blog.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by rameve02 on 28-04-2017.
 */
@Entity
@Table(name="match_player_details")
public class MatchPlayerDetails {

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

    @Column(name="modifiedDate")
    Date modifiedDate;

    @Column(name="createdDate")
    Date createdDate;



    public MatchPlayerDetails() {
        super();
    }

    public MatchPlayerDetails(Integer id, Player player, Match match, Date modifiedDate, Date createdDate) {
        this.id = id;
        this.player = player;
        this.match = match;
        this.modifiedDate = modifiedDate;
        this.createdDate = createdDate;
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
}
