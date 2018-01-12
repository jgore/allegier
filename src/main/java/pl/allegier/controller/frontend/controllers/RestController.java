package pl.allegier.controller.frontend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Pawel Szczepkowski | GoreIT on 10.08.17.
 */
public interface RestController<DTO> {

    /**
     * get count of all entities
     *
     * @param request request
     * @return
     */
    ResponseEntity<Long> getCount(final HttpServletRequest request);

    /**
     * generic rest controller for get all entities
     *
     * @param request request
     * @return
     */
    ResponseEntity<List<DTO>> getAll(HttpServletRequest request, final Integer page, final Integer size);

    /**
     * generic rest controller for get one by id
     *
     * @param id
     * @param request request
     * @return
     */

    ResponseEntity<DTO> getOne(@PathVariable("id") String id, HttpServletRequest request);

    /**
     * generic rest controller for creating entity
     *
     * @param dto     dto
     * @param request
     * @return
     */

    ResponseEntity<DTO> create(@RequestBody DTO dto, HttpServletRequest request);

    /**
     * generic rest controller for update entity
     *
     * @param dto
     * @param id
     * @param request
     * @return
     */

    ResponseEntity<DTO> update(@RequestBody DTO dto, @PathVariable("id") String id, HttpServletRequest request);

    /**
     * generic rest controller for delete entity
     *
     * @param id
     * @param request
     * @return
     */

    ResponseEntity delete(@PathVariable("id") String id, HttpServletRequest request);

}
