package pl.allegier.controller.frontend.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import pl.allegier.model.OrderProduct;
import pl.allegier.model.id.IIdentifable;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by Pawel Szczepkowski | GoreIT on 18.04.17.
 */
public class OrderDto extends TimeStampDto implements Serializable, IIdentifable<Integer> {

    private static final long serialVersionUID = 4547295716691998643L;

    private Integer id;

    private Integer account;
    private Set<OrderProductDto> orderProductDtos;

    public final Integer getId() {
        return id;
    }

    public final void setId(final Integer id) {
        this.id = id;
    }

    public final Integer getAccount() {
        return account;
    }

    public final void setAccount(final Integer account) {
        this.account = account;
    }

    public final Set<OrderProductDto> getOrderProductDtos() {
        return orderProductDtos;
    }

    public final void setOrderProductDtos(final Set<OrderProductDto> orderProductDtos) {
        this.orderProductDtos = orderProductDtos;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
