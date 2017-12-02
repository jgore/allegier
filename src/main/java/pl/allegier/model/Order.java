package pl.allegier.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Pawel Szczepkowski | GoreIT on 14.04.17.
 */

@Entity
@Table(name = "ORDERS")
public class Order extends Timestamp implements Identifable<Integer>, Serializable {

    private static final long serialVersionUID = -4955525052994793695L;

    private Integer id;

    private Account account;
    private Set<OrderProduct> orderProducts;

    public Order() {
        this.setCreated( new Date() );
        this.setUpdated( new Date() );
    }

    public Order(Account account, Set<OrderProduct> orderProducts) {
        this.account = account;
        this.orderProducts = orderProducts;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    @ManyToOne(targetEntity = Account.class)
    public Account getAccount() {
        return account;
    }

    @OneToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REMOVE },
            mappedBy = "order",fetch = FetchType.EAGER,
    orphanRemoval = true)
    public Set<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setOrderProducts(Set<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString(this);
    }

}
