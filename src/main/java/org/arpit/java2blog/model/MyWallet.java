package org.arpit.java2blog.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by rameve02 on 28-04-2017.
 */
@Entity
@Table(name="my_wallet")
public class MyWallet {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;

    @Column(name="amount")
    Long amount;

    @OneToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "person_id")
    Person person;

    @Column(name="modifiedDate")
    Date modifiedDate;

    @Column(name="createdDate")
    Date createdDate;

    public MyWallet() {
        super();
    }

    public MyWallet(Integer id, Long amount, Person person, Date modifiedDate, Date createdDate) {
        this.id = id;
        this.amount = amount;
        this.person = person;
        this.modifiedDate = modifiedDate;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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
