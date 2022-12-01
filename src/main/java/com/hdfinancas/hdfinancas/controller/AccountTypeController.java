package com.hdfinancas.hdfinancas.controller;

import com.hdfinancas.hdfinancas.model.AccountTypeModel;
import com.hdfinancas.hdfinancas.model.UserModel;
import com.hdfinancas.hdfinancas.service.AccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accountType")
public class AccountTypeController {

    @Autowired
    private AccountTypeService service;

    @GetMapping()
    public List<AccountTypeModel> findAll() { return service.findAll(); }

    @GetMapping("/{id}")
    public Optional<AccountTypeModel> findById(@PathVariable("id") long id) { return service.findById(id); }

    @PostMapping( produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public AccountTypeModel save(@RequestBody AccountTypeModel model) { return service.save(model); }
}
