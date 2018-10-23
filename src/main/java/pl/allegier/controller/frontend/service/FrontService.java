package pl.allegier.controller.frontend.service;

/**
 * Created by Pawel Szczepkowski | GoreIT on 14.04.17.
 */
public interface FrontService<DTO, ID> {

    DTO save(DTO var1);

    DTO update(DTO var1);

    DTO findOne(ID var1);

    boolean exists(ID var1);

    Iterable<DTO> findAll(int size, int page);

    Iterable<DTO> findByField(int size, int page, String field, String value);

    long count();

    void delete(ID var1);

    void deleteAll();
}
