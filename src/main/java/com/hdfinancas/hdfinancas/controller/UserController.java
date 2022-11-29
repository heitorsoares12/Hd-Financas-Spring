package com.hdfinancas.hdfinancas.controller;

import com.hdfinancas.hdfinancas.model.UserModel;
import com.hdfinancas.hdfinancas.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@Api(value = "User Endpoint")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE })
    @ApiOperation(value = "Returns a User by ID")
    public UserModel findById(
            @ApiParam(name = "id", value = "A valid integer value", required = true)
            @PathVariable("id") long id){
        var userModel = service.findById(id);
        if(userModel.isPresent()){
            buildEntityLink(userModel.get());
            return userModel.get();
        } else {
            return null;
        }
    }

    @GetMapping( produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<UserModel> findAll() { return  service.findAll(); }

    @PostMapping( produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
    consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public UserModel save(@RequestBody UserModel model) { return service.save(model); }

    @PutMapping( produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public UserModel update(@RequestBody UserModel model) { return service.update(model); }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        Optional<UserModel> found = service.findById(id);
        if(found.isPresent()){
            service.delete(id);
            return ResponseEntity.ok().build();
        } else {
            return null;
        }
    }

    @GetMapping("find/email/{email}")
    public List<UserModel> findByEmail(@PathVariable("email") String email) { return service.findByEmail(email); }


    private void buildEntityLink(UserModel model){
        model.add(
                WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(
                                this.getClass()).findById(model.getId())
                ).withSelfRel()
        );
    }
}
