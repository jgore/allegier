package pl.allegier.controller.frontend.dto;

import pl.allegier.model.Identifable;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Pawel Szczepkowski | Satlan on 10.08.17.
 */
public class BidDto implements Serializable,Identifable<Integer>{

    private static final long serialVersionUID = -2231985404824753846L;

    private Integer id;
    private BigDecimal price;

    private Integer accountId;
    private Integer auctionId;

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

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Integer auctionId) {
        this.auctionId = auctionId;
    }
}
