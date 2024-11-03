package com.library.controller;

import com.library.domain.user.AuthenticationDTO;
import com.library.domain.user.SignupDTO;
import com.library.domain.user.User;

import com.library.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationController {

    @Autowired
    IUserRepository repository;

    @PostMapping("/login")
    private ResponseEntity login(@RequestBody AuthenticationDTO data){
        if (data.email() == null && repository.findByEmail(data.email()) == null){
            return ResponseEntity.badRequest().build();
        }
        User userLogin = repository.findByEmail(data.email());
        if(userLogin.getEmail().equals(data.email()) && userLogin.getPassword().equals(data.password())){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody SignupDTO data){
        if(this.repository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        User newUser = new User(data.name(),data.email(), data.password(), data.role());

        this.repository.save(newUser);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/buscarTodos")
    public ResponseEntity<List<User>> buscarTodos(){
        List<User> users = repository.findAll();
        return ResponseEntity.ok(users);
    };
}
