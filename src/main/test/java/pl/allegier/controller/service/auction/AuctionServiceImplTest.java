package pl.allegier.controller.service.auction;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import pl.allegier.controller.dao.auction.AuctionDao;
import pl.allegier.model.Account;
import pl.allegier.model.Auction;
import pl.allegier.model.Bid;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

/**
 * Created by Pawel Szczepkowski | GoreIT on 10.08.17.
 */

@RunWith(MockitoJUnitRunner.class)
public class AuctionServiceImplTest {

    @Mock
    private AuctionDao dao;

    @InjectMocks
    private AuctionServiceImpl sut;


    @Before
    public  void setup()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addBidShouldAddBidToAuction()
    {
        //given
        Bid bid = new Bid();
        Auction auction = new Auction();
        Mockito.when(sut.findOne(any())).thenReturn(auction);

        //when
        sut.addBid( 1 , bid);

        //then
        assertTrue( auction.getBids().contains(bid));
//        verify(dao).save(any());

    }
}