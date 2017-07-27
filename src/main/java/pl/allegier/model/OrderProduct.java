package pl.allegier.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created by gore on 24.07.17.
 */

@Entity
@Table(name = "ORDER_PRODUCTS")
public class OrderProduct implements Serializable {

    private static final long serialVersionUID = 1039726237347294105L;

    private Integer id;

    private Order order;
    private Product product;
    private int amount;

    private Date created;
    private Date updated;

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    @ManyToOne(targetEntity = Order.class)
    @JoinColumn(name="order_id",nullable = false)
    public Order getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }

    @Column(name = "amount")
    public int getAmount() {
        return amount;
    }

    @CreationTimestamp
    @Column(updatable = false)
    public Date getCreated() {
        return created;
    }

    @UpdateTimestamp
    @Column
    public Date getUpdated() {
        return updated;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }


    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString(this);
    }
}
