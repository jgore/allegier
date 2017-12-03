package pl.allegier.controller.frontend.mapper;

/**
 * Created by Pawel Szczepkowski | GoreIT on 14.04.17.
 *
 * Mapper should map DTO -> DO and DO -> DTO
 *
 * @param <DTO> DTO>Data Transfer object for mapping
 * @param <DO>  Data Object for mapping
 */
public interface Mapper<DTO, DO> {

    /**
     *
     * @param dto to be mapped
     * @return mapped DO
     */
    DO toDao(DTO dto);

    /**
     *
     * @param dao to be mapped
     * @return mapped DTO
     */

    DTO toDto(DO dao);

}
