package pl.allegier.controller.frontend.dto;

import pl.allegier.model.id.IIdentifable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by Pawel Szczepkowski | GoreIT on 10.08.17.
 */
public class AuctionDto extends AbstractProductDto implements Serializable, IIdentifable<Integer> {
    private static final long serialVersionUID = 1552366802875767338L;

    private Set<Integer> bids;

    public AuctionDto() {
    }

    public AuctionDto(String title, String description, BigDecimal price) {
        super(title, description, price);
    }

    public final void setBids(Set<Integer> bids) {
        this.bids = bids;
    }

    public final Set<Integer> getBids() {
        return bids;
    }
}
