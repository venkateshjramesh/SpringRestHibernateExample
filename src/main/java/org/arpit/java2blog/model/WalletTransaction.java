package org.arpit.java2blog.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by rameve02 on 28-04-2017.
 */
@Entity
@Table(name="wallet_transaction")
public class WalletTransaction {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;

    @Column(name="amount")
    Long amount;

    @Column(name="transactionType")
    String transactionType;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "wallet_id")
    MyWallet myWallet;

    @Column(name="modifiedDate")
    Date modifiedDate;

    @Column(name="createdDate")
    Date createdDate;

    public WalletTransaction() {
        super();
    }

    public WalletTransaction(Integer id, Long amount, String transactionType, MyWallet myWallet, Date modifiedDate, Date createdDate) {
        this.id = id;
        this.amount = amount;
        this.transactionType = transactionType;
        this.myWallet = myWallet;
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

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public MyWallet getMyWallet() {
        return myWallet;
    }

    public void setMyWallet(MyWallet myWallet) {
        this.myWallet = myWallet;
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
