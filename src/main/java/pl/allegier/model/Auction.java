package pl.allegier.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by Pawel Szczepkowski | Satlan on 10.08.17.
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

}
