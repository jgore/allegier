package pl.allegier.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Pawel Szczepkowski | Satlan on 14.04.17.
 */

@Entity
@Table(name = "ORDERS")
public class Order implements Serializable {

    private static final long serialVersionUID = -4955525052994793695L;

    private Integer id;

    private Account account;
    private Set<OrderProduct> orderProducts;

    private Date created;
    private Date updated;

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

    public Account getAccount() {
        return account;
    }

    @OneToMany(mappedBy = "order")
    public Set<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    @Column
    public Date getCreated() {
        return created;
    }

    @Column
    public Date getUpdated() {
        return updated;
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

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(getId(), order.getId()) &&
                Objects.equals(getAccount(), order.getAccount()) &&
                Objects.equals(getOrderProducts(), order.getOrderProducts()) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAccount(), getOrderProducts());
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString(this);
    }

}
