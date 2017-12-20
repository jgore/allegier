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

        /*
         * Created by Pawel Szczepkowski | GoreIT on 10.08.17.
         */

/**
 * Abstract Rest Controller with Basic used methods.
 *
 * @param <DTO>
 * @param <ID>
 */
public abstract class AbstractRestController<DTO extends IIdentifable<ID>, ID> implements RestController<DTO> {

    /**
     * front service to be mainly used in controller
     *
     * @return
     */
    public abstract FrontService<DTO, ID> getFrontService();

    @RequestMapping(method = RequestMethod.GET)
    @Override
    public final ResponseEntity<List<DTO>> getAll() {

        ArrayList<DTO> dtos = Lists.newArrayList(getFrontService().findAll());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @Override
    public final ResponseEntity<DTO> getOne(@PathVariable("id") final String id) {

        DTO dto = getFrontService().findOne((ID) Integer.valueOf(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    @Override
    public final ResponseEntity<DTO> create(@RequestBody final DTO dto) {

        DTO saved = getFrontService().save(dto);
        return new ResponseEntity<>(saved, HttpStatus.OK);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    @Override
    public final ResponseEntity<DTO> update(@RequestBody final DTO dto, @PathVariable("id") final String id) {

        DTO update = getFrontService().update(dto);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @ExceptionHandler(IllegalArgumentException.class)
    @Override
    public final ResponseEntity delete(@PathVariable("id") final String id) {

        getFrontService().delete((ID) Integer.valueOf(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
