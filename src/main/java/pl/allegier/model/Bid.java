package pl.allegier.model;

import pl.allegier.model.timestamp.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Pawel Szczepkowski | GoreIT on 10.08.17.
 */

@Entity
@Table(name = "BIDS")
public class Bid extends Timestamp implements Serializable{
    private static final long serialVersionUID = -6152290436485091589L;

    private Integer id;
    private BigDecimal price;

    private Account account;
    private Auction auction;


    @Id
    @GeneratedValue
    public final Integer getId() {
        return id;
    }

    @ManyToOne(targetEntity = Account.class,cascade = CascadeType.ALL)
    @JoinColumn(name="account_id",nullable = false)
    public final Account getAccount() {
        return account;
    }

    @ManyToOne(targetEntity = Auction.class)
    @JoinColumn(name="auction_id",nullable = false)
    public final Auction getAuction() {
        return auction;
    }

    @Column
    public  final BigDecimal getPrice() {
        return price;
    }

    public final void setId(Integer id) {
        this.id = id;
    }

    public final void setPrice(BigDecimal price) {
        this.price = price;
    }

    public final void setAccount(Account account) {
        this.account = account;
    }

    public final void setAuction(Auction auction) {
        this.auction = auction;
    }



}
