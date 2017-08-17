package pl.allegier.controller.frontend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by Pawel Szczepkowski | Satlan on 10.08.17.
 */
public interface RestController<DTO> {

    ResponseEntity<List<DTO>> getAll() ;

    ResponseEntity<DTO> getOne(@PathVariable("id") String id) ;

    ResponseEntity<DTO> create(@RequestBody DTO dto) ;

    ResponseEntity<DTO> update(@RequestBody DTO dto, @PathVariable("id") String id) ;

    ResponseEntity delete( @PathVariable("id") String id) ;

}
