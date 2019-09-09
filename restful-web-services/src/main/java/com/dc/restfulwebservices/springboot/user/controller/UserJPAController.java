package com.dc.restfulwebservices.springboot.user.controller;

import com.dc.restfulwebservices.springboot.user.bean.Post;
import com.dc.restfulwebservices.springboot.user.bean.User;
import com.dc.restfulwebservices.springboot.user.dao.UserDaoService;
import com.dc.restfulwebservices.springboot.user.exceptions.UserNotFoundException;
import com.dc.restfulwebservices.springboot.user.repository.PostRespository;
import com.dc.restfulwebservices.springboot.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jpa")
public class UserJPAController {

    @Autowired
    private UserDaoService userDaoService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRespository postRespository;

    @GetMapping("/users")
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
            throw new UserNotFoundException("Id - "+id);
        }
        return user.get();
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User  savedUser = userRepository.save(user);

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
        userRepository.deleteById(id);
    }

    @GetMapping("/users/{id}/posts")
    public List<Post> getAllPostForUser(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
            throw new UserNotFoundException("Id - "+id);
        }
        return user.get().getPosts();
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<User> createPost(@PathVariable int id,@Valid @RequestBody Post post){
        Optional<User> savedUser = userRepository.findById(id);

        if(!savedUser.isPresent()){
            throw new UserNotFoundException("Id - "+ id);
        }

        User user = savedUser.get();

        post.setUser(user);
        postRespository.save(post);

        URI location  = ServletUriComponentsBuilder.
                fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(post.getId())
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json; charset=utf-8");
        headers.add("location",location.toString());



        return new ResponseEntity(post,headers, HttpStatus.CREATED);
    }

}
