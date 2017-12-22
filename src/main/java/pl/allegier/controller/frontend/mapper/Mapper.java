package pl.allegier.controller.frontend.mapper;

/**
 * Created by Pawel Szczepkowski | GoreIT on 14.04.17.
 *
 * Mapper should map DTO -> DO and DO -> DTO
 *
 * @param <DTO> DTO>Data Transfer object for mapping
 * @param <ENTITY>  Data Object for mapping
 */
public interface Mapper<DTO, ENTITY> {

    /**
     *
     * @param dto to be mapped
     * @return ENTITY mapped entity
     */
    ENTITY toDao(DTO dto);

    /**
     *
     * @param entity to be mapped
     * @return mapped DTO
     */

    DTO toDto(ENTITY entity);

}
