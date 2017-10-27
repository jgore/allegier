package pl.allegier.controller.frontend.dto;

import pl.allegier.model.Order;
import pl.allegier.model.Product;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Pawel Szczepkowski | Satlan on 27.10.17.
 */
public class OrderProductDto implements Serializable {

    private static final long serialVersionUID = 4547295416691998643L;

    private Integer id;

    private Integer order;
    private Integer product;
    private int amount;

    private Date created;
    private Date updated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
