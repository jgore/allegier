package pl.allegier.controller.dao.auction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.allegier.controller.dao.AbstractDaoTest;
import pl.allegier.controller.dao.Dao;
import pl.allegier.controller.dao.DaoTest;
import pl.allegier.controller.dao.category.CategoryDao;
import pl.allegier.model.Auction;
import pl.allegier.model.Category;

import java.math.BigDecimal;

/**
 * Created by Pawel Szczepkowski | Satlan on 10.08.17.
 */
@Component
public class AuctionDaoTest extends AbstractDaoTest<Auction, Integer> implements DaoTest<Auction,Integer> {

    public static final String TEST_PROD_TITLE_1 = " TEST _ PROD _ TITLE 1";
    public static final String TEST_PROD_TITLE_2 = " TEST _ PROD _ TITLE 2";
    public static final String TEST_DESCRIPTION = " TEST _ PROD _ DESC ";
    public static final BigDecimal TEST_PRICE = BigDecimal.valueOf(123);

    @Autowired
    private AuctionDao auctionDao;

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Dao<Auction, Integer> getRepository() {
        return auctionDao;
    }

    @Override
    public Auction createEntity() {
        Auction product = new Auction(TEST_PROD_TITLE_1, TEST_DESCRIPTION, TEST_PRICE);
        Category category = createCategory();
        Category save = categoryDao.save(category);
        product.setCategory(save);
        return product;
    }

    public Category createCategory()
    {
        Category category = new Category();
        category.setId("1234");

        return category;
    }
}