package pl.allegier.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

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
public class OrderProduct implements Serializable {

    private static final long serialVersionUID = 1039726237347294105L;

    private Integer id;

    private Order order;
    private Product product;
    private int amount;


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

    @ManyToOne(targetEntity = Product.class, fetch = FetchType.EAGER)
    @JoinColumn(name="product_id",nullable = false)
    public Product getProduct() {
        return product;
    }

    @Column
    public int getAmount() {
        return amount;
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




    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString(this);
    }
}
