package pl.allegier.controller.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import pl.allegier.TestConfiguration;
import pl.allegier.model.Identifable;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Pawel Szczepkowski | Java4you.pl  on 21.05.17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public abstract class AbstractDaoTest<E extends Identifable<ID>, ID> implements DaoTest<E, ID> {

    private Dao<E,ID> repository;

    public abstract Dao<E, ID> getRepository();

    public abstract E createEntity();

    @Before
    public void setup()
    {
        repository = getRepository();
    }

    @After
    public void cleanUp()
    {
        repository.removeAll();
    }

    @Override
    @Test
    public void saveOneTest() {
        E entity = createEntity();
        E saved = repository.save(entity);

        E persisted = repository.findById(saved.getId());
        assertThat( saved.getId(), equalTo( persisted.getId() ));
    }

    @Override
    @Test
    public void updateOneTest() {
        E entity = createEntity();
        E save = repository.save(entity);
        E persisted = repository.findById(save.getId());
        E update = repository.update(persisted);

        assertNotNull(update);
    }

    @Override
    @Test
    public void removeOneTest() {
        E entity = createEntity();
        E saved = repository.save(entity);
        repository.remove(saved);

        repository.findById(saved.getId());
    }

    @Override
    @Test
    public void findByIdTest() {
        E entity = createEntity();
        E saved = repository.save(entity);
        E persisted = repository.findById(saved.getId());

        assertNotNull( persisted );
    }

    @Override
    @Test
    public void findAllTest() {
        E entity = createEntity();
        repository.save(entity);
        List<E> all = repository.findAll();
        assertThat( all.size(), equalTo(1));
    }

    @Override
    @Test
    public void countTest() {
        E entity = createEntity();
        repository.save(entity);
        assertThat( repository.count() , equalTo(1L) );
    }

    @Override
    @Test
    public void removeAllTest() {
        E entity = createEntity();
        repository.save(entity);
        repository.removeAll();

        assertThat( repository.count(),equalTo(0L));
    }
}
