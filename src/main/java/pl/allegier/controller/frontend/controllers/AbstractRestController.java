package pl.allegier.controller.frontend.controllers;

import com.google.common.collect.Lists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.allegier.controller.frontend.service.FrontService;
import pl.allegier.model.id.IIdentifable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pawel Szczepkowski | GoreIT on 10.08.17.
 */
public abstract class AbstractRestController<DTO extends IIdentifable<ID>,ID> implements RestController<DTO> {

    public abstract FrontService<DTO, ID> getFrontService( );

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<DTO>> getAll() {

        ArrayList<DTO> dtos = Lists.newArrayList(getFrontService().findAll());

        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<DTO> getOne(@PathVariable("id") String id) {

        DTO dto = getFrontService().findOne((ID) Integer.valueOf(id));

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<DTO> create(@RequestBody DTO dto) {

        DTO saved = getFrontService().save(dto);

        return new ResponseEntity<>(saved, HttpStatus.OK);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<DTO> update(@RequestBody DTO dto, @PathVariable("id") String id) {

        DTO update = getFrontService().update(dto);

        return new ResponseEntity<>(update, HttpStatus.OK);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity delete( @PathVariable("id") String id) {

        getFrontService().delete((ID) Integer.valueOf(id));

        return new ResponseEntity<>( HttpStatus.OK);

    }
}
