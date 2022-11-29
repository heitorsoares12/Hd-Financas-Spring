package com.hdfinancas.hdfinancas.service;

import com.hdfinancas.hdfinancas.model.AccountTypeModel;
import com.hdfinancas.hdfinancas.repository.AccountTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountTypeService {

    @Autowired
    private AccountTypeRepository repository;

    public List<AccountTypeModel> findAll() { return repository.findAll(); }

    public Optional<AccountTypeModel> findById(long id ) { return repository.findById(id); }

}
