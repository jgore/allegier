package pl.allegier.controller.frontend.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import pl.allegier.model.OrderProduct;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by Pawel Szczepkowski | GoreIT on 18.04.17.
 */
public class OrderDto extends TimeStampDto implements Serializable {

    private static final long serialVersionUID = 4547295716691998643L;

    private Integer id;

    private Integer account;
    private Set<OrderProductDto> orderProductDtos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public Set<OrderProductDto> getOrderProductDtos() {
        return orderProductDtos;
    }

    public void setOrderProductDtos(Set<OrderProductDto> orderProductDtos) {
        this.orderProductDtos = orderProductDtos;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString(this);
    }
}
