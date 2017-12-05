package pl.allegier.controller.service.auction;

import pl.allegier.controller.service.Service;
import pl.allegier.model.Auction;
import pl.allegier.model.Bid;

/**
 * Created by Pawel Szczepkowski | GoreIT on 10.08.17.
 */
public interface AuctionService extends Service<Auction, Integer> {
    void addBid(Integer auctionId, Bid bid);
}
