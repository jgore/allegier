package pl.allegier.controller.frontend.mapper;

/**
 * Created by Pawel Szczepkowski | GoreIT on 14.04.17.
 */
public interface Mapper<DTO, DO> {

    DO toDao(DTO dto);

    DTO toDto(DO dao) ;

}
