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

    public final Integer getId() {
        return id;
    }

    public final void setId(final Integer id) {
        this.id = id;
    }

    public final Integer getOrder() {
        return order;
    }

    public final void setOrder(final Integer order) {
        this.order = order;
    }

    public final Integer getProduct() {
        return product;
    }

    public final void setProduct(final Integer product) {
        this.product = product;
    }

    public final int getAmount() {
        return amount;
    }

    public final void setAmount(final int amount) {
        this.amount = amount;
    }

}
