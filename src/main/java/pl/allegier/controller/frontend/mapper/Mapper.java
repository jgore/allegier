package pl.allegier.controller.frontend.mapper;

/**
 * Created by Pawel Szczepkowski | Satlan on 14.04.17.
 */
public interface Mapper<DTO,DAO> {

    DAO fromDto(DTO dto);

    DTO fromDao(DAO dao) ;

}
