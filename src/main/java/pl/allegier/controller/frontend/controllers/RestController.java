package pl.allegier.controller.frontend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by Pawel Szczepkowski | GoreIT on 10.08.17.
 */
public interface RestController<DTO> {
    /**
     * generic rest controller for get all entities
     * @return
     */
    ResponseEntity<List<DTO>> getAll();

    /**
     * generic rest controller for get one by id
     * @param id
     * @return
     */

    ResponseEntity<DTO> getOne(@PathVariable("id") String id) ;

    /**
     * generic rest controller for creating entity
     * @param dto dto
     * @return
     */

    ResponseEntity<DTO> create(@RequestBody DTO dto);

    /**
     * generic rest controller for update entity
     * @param dto
     * @param id
     * @return
     */

    ResponseEntity<DTO> update(@RequestBody DTO dto, @PathVariable("id") String id) ;

    /**
     *  generic rest controller for delete entity
     * @param id
     * @return
     */

    ResponseEntity delete(@PathVariable("id") String id) ;

}
