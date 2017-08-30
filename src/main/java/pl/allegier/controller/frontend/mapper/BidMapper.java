package pl.allegier.controller.frontend.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.allegier.controller.dao.account.AccountDao;
import pl.allegier.controller.dao.auction.AuctionDao;
import pl.allegier.controller.frontend.dto.AccountDto;
import pl.allegier.controller.frontend.dto.BidDto;
import pl.allegier.controller.frontend.service.account.AccountFrontService;
import pl.allegier.controller.frontend.service.auction.AuctionFrontService;
import pl.allegier.controller.service.account.AccountService;
import pl.allegier.controller.service.auction.AuctionService;
import pl.allegier.model.Bid;

/**
 * Created by Pawel Szczepkowski | Satlan on 10.08.17.
 */
@Component
public class BidMapper implements Mapper<BidDto,Bid> {

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private AccountService accountService;

    private static final ModelMapper mapper = new ModelMapper();

    @Override
    public Bid toDao(BidDto bidDto) {
        Bid bid = mapper.map(bidDto, Bid.class);
        bid.setAccount( accountService.findOne(bidDto.getAccountId()));
        bid.setAuction(auctionService.findOne( bidDto.getAuctionId()));

        return bid;
    }

    @Override
    public BidDto toDto(Bid bid) {
        return mapper.map(bid,BidDto.class);
    }
}
