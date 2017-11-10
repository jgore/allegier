package pl.allegier.controller.dao.auction;

import org.springframework.stereotype.Repository;
import pl.allegier.controller.dao.JpaDao;
import pl.allegier.model.Auction;

/**
 * Created by Pawel Szczepkowski | GoreIT on 10.08.17.
 */

@Repository("auctionDao")
public class AuctionDaoImpl extends JpaDao<Auction,Integer> implements AuctionDao {
}
