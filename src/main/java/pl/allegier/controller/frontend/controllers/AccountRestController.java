package pl.allegier.controller.frontend.controllers;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.allegier.controller.frontend.dto.AccountDto;
import pl.allegier.controller.frontend.service.account.AccountFrontService;

import java.util.List;

/**
 * Created by Pawel Szczepkowski | GoreIT on 13.04.17.
 */
@RestController
@RequestMapping("rest/accounts")
public class AccountRestController {

    private final AccountFrontService accountFrontService;

    @Autowired
    public AccountRestController(AccountFrontService accountFrontService) {
        this.accountFrontService = accountFrontService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<AccountDto>> getAll() {

        List<AccountDto> accountDtos = Lists.newArrayList(accountFrontService.findAll());

        return new ResponseEntity<>(accountDtos, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<AccountDto> getOne(@PathVariable("id") String id) {

        AccountDto accountDto = accountFrontService.findOne(Integer.valueOf(id));

        return new ResponseEntity<>(accountDto, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, headers = "Content-Type=application/json")
    @ResponseBody
    public ResponseEntity<AccountDto> create(@RequestBody AccountDto dto) {

        AccountDto saved = accountFrontService.save(dto);

        return new ResponseEntity<>(saved, HttpStatus.OK);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = "Content-Type=application/json")
    @ResponseBody
    public ResponseEntity<AccountDto> update(@RequestBody AccountDto dto, @PathVariable("id") String id) {

        AccountDto saved = accountFrontService.save(dto);

        return new ResponseEntity<>(saved, HttpStatus.OK);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity delete(@RequestBody AccountDto dto, @PathVariable("id") String id) {

        accountFrontService.delete(dto.getId());

        return new ResponseEntity<>( HttpStatus.OK);

    }

}
