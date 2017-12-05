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
    public final Integer getId() {
        return id;
    }

    @Override
    public final void setId(final Integer id) {
        this.id = id;
    }

    public final BigDecimal getPrice() {
        return price;
    }

    public final void setPrice(final BigDecimal price) {
        this.price = price;
    }

    public final Integer getAccount() {
        return account;
    }

    public final void setAccount(final Integer account) {
        this.account = account;
    }

    public final Integer getAuction() {
        return auction;
    }

    public final void setAuction(final Integer auction) {
        this.auction = auction;
    }
}
