package pl.allegier.controller.frontend.service;

import com.google.common.collect.Lists;
import pl.allegier.controller.frontend.mapper.Mapper;
import pl.allegier.controller.service.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Pawel Szczepkowski | Satlan on 14.04.17.
 */

public abstract class AbstractFrontService<DTO,DAO,ID> implements FrontService<DTO,ID> {

    protected final Mapper<DTO,DAO> mapper;

    protected final Service<DAO,ID> service;

    public AbstractFrontService(Mapper<DTO, DAO> mapper, Service<DAO, ID> crudService) {
        this.mapper = mapper;
        this.service = crudService;
    }


    @Override
    public DTO save(DTO dto) {
        DAO dao = mapper.fromDto(dto);
        DAO saved = service.save(dao);

        return mapper.fromDao(saved);
    }

    @Override
    public DTO update(DTO dto) {
        DAO update = service.update(mapper.fromDto(dto));
        return mapper.fromDao( update);
    }

    @Override
    public DTO findOne(ID id) {
        DAO dao = service.findOne(id);

        return mapper.fromDao(dao);
    }

    @Override
    public boolean exists(ID id) {
        return service.exists( id);
    }

    @Override
    public Iterable<DTO> findAll() {
        Iterable<DAO> all = service.findAll();
        List<DAO> daos = Lists.newArrayList(all);

        return daos.
                stream().
                map(mapper::fromDao)
                .collect(Collectors.toList());
    }


    @Override
    public long count() {
        return service.count();
    }

    @Override
    public void delete(ID id) {
        service.delete( id );
    }

    @Override
    public void deleteAll() {
        service.deleteAll();
    }
}
