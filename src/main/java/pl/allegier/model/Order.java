package pl.allegier.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import pl.allegier.model.id.IIdentifable;
import pl.allegier.model.timestamp.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by Pawel Szczepkowski | GoreIT on 14.04.17.
 */

@Entity
@Table(name = "ORDERS")
public class Order extends Timestamp implements IIdentifable<Integer>, Serializable {

    private static final long serialVersionUID = -4955525052994793695L;

    private Integer id;

    private Account account;
    private Set<OrderProduct> orderProducts;

    public Order() {
        this.setCreated(new Date());
        this.setUpdated(new Date());
    }

    public Order(final Account account, final Set<OrderProduct> orderProducts) {
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

    public final void setId(Integer id) {
        this.id = id;
    }

    public final void setAccount(Account account) {
        this.account = account;
    }

    public final void setOrderProducts(final Set<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString(this);
    }

}
