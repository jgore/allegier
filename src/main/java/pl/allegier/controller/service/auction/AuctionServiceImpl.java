package pl.allegier.controller.service.auction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.allegier.controller.dao.Dao;
import pl.allegier.controller.service.AbstractService;
import pl.allegier.model.Auction;
import pl.allegier.model.Bid;

import java.util.Set;

/**
 * Created by Pawel Szczepkowski | GoreIT on 10.08.17.
 */

@Service
public class AuctionServiceImpl extends AbstractService<Auction, Integer> implements AuctionService {

    @Autowired
    public AuctionServiceImpl(@Qualifier("auctionDao") final Dao<Auction, Integer> dao) {
        super(dao);
    }

    @Override
    public final void addBid(final Integer auctionId, final Bid bid) {

        Auction auction = findOne(auctionId);
        Set<Bid> bids = auction.getBids();

        bids.add(bid);
        auction.setBids(bids);

        save(auction);
    }
}
