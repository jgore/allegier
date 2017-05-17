package pl.allegier.controller.frontend.dto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import pl.allegier.model.Account;
import pl.allegier.model.Product;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Pawel Szczepkowski | Satlan on 18.04.17.
 */
public class OrderDto implements Serializable {

    private static final long serialVersionUID = 4547295716691998643L;



    private Integer id;

    private Account account;
    private Set<Integer> products;

    private Date created;
    private Date updated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<Integer> getProducts() {
        return products;
    }

    public void setProducts(Set<Integer> products) {
        this.products = products;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDto orderDto = (OrderDto) o;
        return Objects.equals(getId(), orderDto.getId()) &&
                Objects.equals(getAccount(), orderDto.getAccount()) &&
                Objects.equals(getProducts(), orderDto.getProducts()) &&
                Objects.equals(getCreated(), orderDto.getCreated()) &&
                Objects.equals(getUpdated(), orderDto.getUpdated());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAccount(), getProducts(), getCreated(), getUpdated());
    }


    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.toString(this);
    }
}
