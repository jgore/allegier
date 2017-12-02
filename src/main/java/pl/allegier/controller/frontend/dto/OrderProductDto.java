package pl.allegier.controller.frontend.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Pawel Szczepkowski | GoreIT on 27.10.17.
 */
public class OrderProductDto extends TimeStampDto implements Serializable {

    private static final long serialVersionUID = 4547295416691998643L;

    private Integer id;

    private Integer order;
    private Integer product;
    private int amount;

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

}
