package com.library.service;

import com.library.domain.user.User;
import com.library.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private IUserRepository repository;

    private User getUserEmail (String email){
        return repository.findByEmail(email);
    }

    private void saveUser (User user){
        repository.save(user);
    }

    private void alterUser(User user){
        repository.save(user);
    }

    private List<User> getAll (){
        return repository.findAll();
    }

    private void removerUserEmail (Long id){
        repository.deleteById(id);
    }
}
