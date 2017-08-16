package pl.allegier.controller.frontend.service.auction;

import org.springframework.beans.factory.annotation.Autowired;
import pl.allegier.controller.frontend.dto.AuctionDto;
import pl.allegier.controller.frontend.dto.BidDto;
import pl.allegier.controller.frontend.mapper.BidMapper;
import pl.allegier.controller.frontend.mapper.Mapper;
import pl.allegier.controller.frontend.service.AbstractFrontService;
import pl.allegier.controller.service.auction.AuctionService;
import pl.allegier.model.Auction;

/**
 * Created by Pawel Szczepkowski | Satlan on 10.08.17.
 */
@org.springframework.stereotype.Service
public class AuctionFrontServiceImpl extends AbstractFrontService<AuctionDto,Auction,Integer> implements AuctionFrontService {

    @Autowired
    private BidMapper bidMapper;

    private final AuctionService auctionService;

    @Autowired
    public AuctionFrontServiceImpl(Mapper<AuctionDto, Auction> mapper, AuctionService auctionService) {
        super(mapper, auctionService);
        this.auctionService = auctionService;
    }


    @Override
    public void addBid(Integer auctionId, BidDto bidDto) {
        auctionService.addBid(auctionId,bidMapper.fromDto(bidDto));
    }
}
