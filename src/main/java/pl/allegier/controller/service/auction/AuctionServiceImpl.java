package pl.allegier.controller.service.auction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.allegier.controller.dao.Dao;
import pl.allegier.controller.service.AbstractService;
import pl.allegier.controller.service.account.AccountService;
import pl.allegier.model.Account;
import pl.allegier.model.Auction;
import pl.allegier.model.Bid;

import javax.transaction.Transactional;
import java.util.Set;

/**
 * Created by Pawel Szczepkowski | Satlan on 10.08.17.
 */

@Service
public class AuctionServiceImpl extends AbstractService<Auction,Integer> implements AuctionService {

    @Autowired
    public AuctionServiceImpl ( @Qualifier("auctionDao") Dao<Auction, Integer> dao) {
        super(dao);
    }


    @Override
    public void addBid(Integer auctionId, Bid bid) {

        Auction auction = findOne(auctionId);
        Set<Bid> bids = auction.getBids();

        bids.add( bid );
        auction.setBids( bids );


        save( auction);
    }
}
