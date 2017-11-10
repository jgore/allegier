package pl.allegier.model;

import com.google.common.collect.Sets;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pawel Szczepkowski | GoreIT on 10.08.17.
 */

@Entity
@Table(name="AUCTIONS")
public class Auction extends AbstractProduct {

    private static final long serialVersionUID = -8884372131412309419L;

    public Auction(String title, String description, BigDecimal price) {
        super(title, description, price);
    }

    public Auction() {
    }

    private Set<Bid> bids ;

    @OneToMany(cascade = {
            CascadeType.ALL },
            mappedBy = "auction",fetch = FetchType.EAGER,
    orphanRemoval = true)
    public Set<Bid> getBids() {
        return  bids != null ? bids : Sets.newHashSet() ;
    }

    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }
}
