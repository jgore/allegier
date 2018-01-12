package pl.allegier.controller.dao;

/**
 * Created by Pawel Szczepkowski | Java4you.pl  on 21.05.17.
 */
public interface DaoTest<E,ID> {

    void saveOneTest();
    void updateOneTest();
    void removeOneTest();
    void findByIdTest();
    void findAllTest();
    void countTest();
    void removeAllTest();
    void findAllPaginatedTest() ;
}
