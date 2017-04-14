package pl.allegier.controller.frontend.service;

import com.google.common.collect.Lists;
import pl.allegier.controller.frontend.mapper.Mapper;
import pl.allegier.controller.service.CrudService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Pawel Szczepkowski | Satlan on 14.04.17.
 */

public abstract class AbstractFrontService<DTO,DAO,ID> implements FrontService<DTO,ID> {

    private final Mapper<DTO,DAO> mapper;

    private final CrudService<DAO,ID> crudService;

    public AbstractFrontService(Mapper<DTO, DAO> mapper, CrudService<DAO, ID> crudService) {
        this.mapper = mapper;
        this.crudService = crudService;
    }


    @Override
    public DTO save(DTO dto) {
        DAO dao = mapper.fromDto(dto);
        DAO saved = crudService.save(dao);

        return mapper.fromDao(saved);
    }

    @Override
    public Iterable<DTO> save(Iterable<DTO> dtoIterable) {
        List<DTO> dtos= Lists.newArrayList(dtoIterable);

        return dtos.stream().
                map(this::save).
                collect(Collectors.toList());
    }

    @Override
    public DTO findOne(ID id) {
        DAO dao = crudService.findOne(id);

        return mapper.fromDao(dao);
    }

    @Override
    public boolean exists(ID id) {
        return crudService.exists( id);
    }

    @Override
    public Iterable<DTO> findAll() {
        Iterable<DAO> all = crudService.findAll();
        List<DAO> daos = Lists.newArrayList(all);

        return daos.
                stream().
                map(mapper::fromDao)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<DTO> findAll(Iterable<ID> idIterables) {
        return null;
    }

    @Override
    public long count() {
        return crudService.count();
    }

    @Override
    public void delete(ID id) {
        crudService.delete( id );
    }

    @Override
    public void delete(Iterable<ID> dtoIterables) {
        dtoIterables.forEach(this::delete);

    }

    @Override
    public void deleteAll() {

    }
}
