package pl.allegier.controller.frontend.controllers;

import com.google.common.collect.Lists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.allegier.controller.frontend.dto.Linked;
import pl.allegier.controller.frontend.service.FrontService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Abstract Rest Controller with Basic used methods.
 *
 * @param <DTO>
 * @param <ID>
 * @author Pawel Szczepkowski | GoreIT
 */
public abstract class AbstractRestController<DTO extends Linked, ID> implements RestController<DTO> {

    private static final int DEFAULT_PAGE_SIZE = 20;

    /**
     * front service to be mainly used in controller
     *
     * @return
     */
    public abstract FrontService<DTO, ID> getFrontService();

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    @Override
    public  ResponseEntity<List<DTO>> getAll(final HttpServletRequest request,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) {

        if (page == null && size == null) {
            page = 0;
            size = 0;
        }

        List<DTO> dtos = Lists.newArrayList(getFrontService().findAll(size, page));
        dtos.forEach(dto -> {
            dto.setLink(request.getRequestURL().toString());
        });
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @RequestMapping(value = "count", method = RequestMethod.GET)
    @Override
    public final ResponseEntity<Long> getCount(final HttpServletRequest request) {

        return new ResponseEntity<>(  getFrontService().count(), HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    @Override
    public final ResponseEntity<DTO> getOne(@PathVariable("id") final String id, final HttpServletRequest request) {

        DTO dto = getFrontService().findOne((ID) Integer.valueOf(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    @Override
    public final ResponseEntity<DTO> create(@RequestBody final DTO dto, final HttpServletRequest request) {

        DTO saved = getFrontService().save(dto);
        return new ResponseEntity<>(saved, HttpStatus.OK);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    @Override
    public final ResponseEntity<DTO> update(@RequestBody final DTO dto, @PathVariable("id") final String id, final HttpServletRequest request) {

        DTO update = getFrontService().update(dto);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @Override
    public final ResponseEntity delete(@PathVariable("id") final String id, final HttpServletRequest request) {

        getFrontService().delete((ID) Integer.valueOf(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
