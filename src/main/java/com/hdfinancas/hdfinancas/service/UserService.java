package com.hdfinancas.hdfinancas.service;

import com.hdfinancas.hdfinancas.model.UserModel;
import com.hdfinancas.hdfinancas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public Optional<UserModel> findById(long id) { return repository.findById(id); }

    public List<UserModel> findAll() { return repository.findAll(); }

    public UserModel save(UserModel model) { return repository.save(model); }

    public UserModel update(UserModel model){
        var found = repository.findById(model.getId());

        if(found.isPresent()){
            found.get().setName((model.getName()));
            found.get().setCpf((model.getCpf()));
            found.get().setEmail((model.getEmail()));
            return repository.save(found.get());
        } else {
            return null;
        }
    }

    public void delete(long id){
        var found = repository.findById(id);
        if(found.isPresent()){
            repository.delete(found.get());
        }
    }

    public List<UserModel> findByEmail(String email) { return repository.findByEmailStartsWithIgnoreCase(email); }
}
