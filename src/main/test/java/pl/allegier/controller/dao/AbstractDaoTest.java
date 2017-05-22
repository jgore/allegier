package pl.allegier.controller.dao;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import pl.allegier.TestConfiguration;

/**
 * Created by Pawel Szczepkowski | Java4you.pl  on 21.05.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public  abstract class AbstractDaoTest<E,ID> {


}
