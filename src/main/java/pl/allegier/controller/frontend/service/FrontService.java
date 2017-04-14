package pl.allegier.controller.frontend.service;

/**
 * Created by Pawel Szczepkowski | Satlan on 14.04.17.
 */
public interface FrontService<DTO,ID> {

    DTO save(DTO var1);

    Iterable<DTO> save(Iterable<DTO> var1);

    DTO findOne(ID var1);

    boolean exists(ID var1);

    Iterable<DTO> findAll();

    Iterable<DTO> findAll(Iterable<ID> var1);

    long count();

    void delete(ID var1);

    void delete(Iterable<ID> ids);

    void deleteAll();
}
