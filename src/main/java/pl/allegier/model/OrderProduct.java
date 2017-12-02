package pl.allegier.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import pl.allegier.controller.frontend.dto.TimeStampDto;
import pl.allegier.model.timestamp.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by gore on 24.07.17.
 */

@Entity
@Table(name = "ORDER_PRODUCTS")
public class OrderProduct extends Timestamp implements Serializable {

    private static final long serialVersionUID = 1039726237347294105L;

    private Integer id;

    private Order order;
    private Product product;
    private int amount;


    @Id
    @GeneratedValue
    public final Integer getId() {
        return id;
    }

    @ManyToOne(targetEntity = Order.class)
    @JoinColumn(name="order_id",nullable = false)
    public final Order getOrder() {
        return order;
    }

    @ManyToOne(targetEntity = Product.class, fetch = FetchType.EAGER)
    @JoinColumn(name="product_id",nullable = false)
    public final Product getProduct() {
        return product;
    }

    @Column
    public final int getAmount() {
        return amount;
    }

    public final void setId(Integer id) {
        this.id = id;
    }

    public final void setOrder(Order order) {
        this.order = order;
    }

    public final void setProduct(Product product) {
        this.product = product;
    }

    public final void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString(this);
    }
}
