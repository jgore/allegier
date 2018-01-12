package pl.allegier.controller.frontend.service;

import com.google.common.collect.Lists;
import pl.allegier.controller.frontend.mapper.Mapper;
import pl.allegier.controller.service.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Pawel Szczepkowski | GoreIT on 14.04.17.
 */

public abstract class AbstractFrontService<DTO, DAO, ID> implements FrontService<DTO, ID> {

    protected final Mapper<DTO, DAO> mapper;

    protected final Service<DAO, ID> service;

    public AbstractFrontService(final Mapper<DTO, DAO> mapper, final Service<DAO, ID> crudService) {
        this.mapper = mapper;
        this.service = crudService;
    }

    @Override
    public final DTO save(final DTO dto) {
        DAO dao = mapper.toDao(dto);
        DAO saved = service.save(dao);

        return mapper.toDto(saved);
    }

    @Override
    public final DTO update(final DTO dto) {
        DAO update = service.update(mapper.toDao(dto));
        return mapper.toDto(update);
    }

    @Override
    public final DTO findOne(final ID id) {
        DAO dao = service.findOne(id);

        return mapper.toDto(dao);
    }

    @Override
    public final boolean exists(final ID id) {
        return service.exists(id);
    }

    @Override
    public final Iterable<DTO> findAll(final int size, final int page) {
        Iterable<DAO> all = service.findAll(size, page);
        List<DAO> daos = Lists.newArrayList(all);

        return daos.
                stream().
                map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public final long count() {
        return service.count();
    }

    @Override
    public void delete(final ID id) {
        service.delete(id);
    }

    @Override
    public final void deleteAll() {
        service.deleteAll();
    }
}
