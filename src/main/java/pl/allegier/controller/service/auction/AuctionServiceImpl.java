package pl.allegier.controller.service.auction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.allegier.controller.dao.Dao;
import pl.allegier.controller.service.AbstractService;
import pl.allegier.model.Auction;

/**
 * Created by Pawel Szczepkowski | Satlan on 10.08.17.
 */

@Service
public class AuctionServiceImpl extends AbstractService<Auction,Integer> implements AuctionService {

    @Autowired
    public AuctionServiceImpl ( @Qualifier("auctionDao") Dao<Auction, Integer> dao) {
        super(dao);
    }
}
