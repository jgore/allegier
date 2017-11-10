package pl.allegier.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Pawel Szczepkowski | GoreIT on 03.04.17.
 */

@Entity
@Table(name = "ACCOUNTS")
public class Account implements Identifable<Integer>, Serializable  {

    private static final long serialVersionUID = 1538176138199455942L;

    private Integer id;

    private String login;
    private String password;

    private Set<Order> orders;
    private Set<Bid> bids;
    private Address address = new Address();

    private Date created;
    private Date updated;

    public Account(String login, String password) {
        super();
        this.login = login;
        this.password = password;
    }

    public Account() { }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }


    @OneToMany(cascade = {
            CascadeType.ALL,
            CascadeType.MERGE,
            CascadeType.REMOVE },
            mappedBy = "account",fetch = FetchType.EAGER)
    public Set<Bid> getBids() {
        return bids;
    }

    @Column
    public String getLogin() {
        return login;
    }

    @Column
    public String getPassword() {
        return password;
    }

    @OneToMany(mappedBy = "account",fetch = FetchType.EAGER)
    public Set<Order> getOrders() {
        return orders;
    }

    @Embedded
    public Address getAddress() {
        return address;
    }

    @UpdateTimestamp
    @Column(updatable = false)
    public Date getCreated() {
        return created;
    }

    @CreationTimestamp
    @Column
    public Date getUpdated() {
        return updated;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return  Objects.equals(getLogin(), account.getLogin()) &&
                Objects.equals(getPassword(), account.getPassword()) &&
                Objects.equals(getOrders(), account.getOrders()) &&
                Objects.equals(getBids(), account.getBids()) &&
                Objects.equals(getAddress(), account.getAddress()) &&
                Objects.equals(getCreated(), account.getCreated()) &&
                Objects.equals(getUpdated(), account.getUpdated());
    }

    @Override
    public int hashCode() {
        return Objects.hash( getLogin(), getPassword(), getOrders(), getBids(), getAddress(), getCreated(), getUpdated());
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString(this);
    }
}
