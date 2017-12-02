package pl.allegier.controller.frontend.dto;

import pl.allegier.model.id.IIdentifable;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Pawel Szczepkowski | GoreIT on 10.08.17.
 */
public class BidDto extends TimeStampDto implements Serializable, IIdentifable<Integer> {

    private static final long serialVersionUID = -2231985404824753846L;

    private Integer id;
    private BigDecimal price;

    private Integer account;
    private Integer auction;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public Integer getAuction() {
        return auction;
    }

    public void setAuction(Integer auction) {
        this.auction = auction;
    }
}
