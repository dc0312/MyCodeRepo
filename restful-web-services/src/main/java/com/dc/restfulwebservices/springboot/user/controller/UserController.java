package com.dc.restfulwebservices.springboot.user.controller;

import com.dc.restfulwebservices.springboot.user.bean.User;
import com.dc.restfulwebservices.springboot.user.dao.UserDaoService;
import com.dc.restfulwebservices.springboot.user.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> getAllUser(){
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        User user = userDaoService.findById(id);
        if(user == null){
            throw new UserNotFoundException("Id - "+id);
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User  savedUser = userDaoService.save(user);

        URI location  = ServletUriComponentsBuilder.
                fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json; charset=utf-8");
        headers.add("location",location.toString());



        return new ResponseEntity(savedUser,headers, HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        if(userDaoService.deleteById(id)){
            return;
        }else{
            throw new UserNotFoundException("Id - "+id);
        }
    }

}
