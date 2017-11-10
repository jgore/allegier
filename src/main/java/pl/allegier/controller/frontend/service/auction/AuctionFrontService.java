package pl.allegier.controller.frontend.service.auction;

import pl.allegier.controller.frontend.dto.AuctionDto;
import pl.allegier.controller.frontend.dto.BidDto;
import pl.allegier.controller.frontend.service.FrontService;

/**
 * Created by Pawel Szczepkowski | GoreIT on 10.08.17.
 */
public interface AuctionFrontService extends FrontService<AuctionDto,Integer> {
    void addBid(Integer auctionId, BidDto bidDto);

}
