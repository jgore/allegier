package pl.allegier.controller.frontend.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.allegier.controller.frontend.dto.BidDto;
import pl.allegier.controller.service.account.AccountService;
import pl.allegier.controller.service.auction.AuctionService;
import pl.allegier.model.Bid;

/**
 * Created by Pawel Szczepkowski | GoreIT on 10.08.17.
 */
@Component
public class BidMapper implements Mapper<BidDto, Bid> {

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AllegierModelMapper mapper;

    @Override
    public Bid toDao(final BidDto bidDto) {
        Bid bid = mapper.map(bidDto, Bid.class);
        bid.setAccount(accountService.findOne(bidDto.getAccount()));
        bid.setAuction(auctionService.findOne(bidDto.getAuction()));

        return bid;
    }

    @Override
    public BidDto toDto(final Bid bid) {
        return mapper.map(bid, BidDto.class);
    }
}
