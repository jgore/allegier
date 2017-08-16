package pl.allegier.controller.frontend.dto;

import pl.allegier.model.Identifable;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by Pawel Szczepkowski | Satlan on 10.08.17.
 */
public class AuctionDto extends AbstractProductDto implements Serializable,Identifable<Integer> {
    private static final long serialVersionUID = 1552366802875767338L;

    private Set<Integer> bids;

    public Set<Integer> getBids() {
        return bids;
    }

    public void setBids(Set<Integer> bids) {
        this.bids = bids;
    }
}
