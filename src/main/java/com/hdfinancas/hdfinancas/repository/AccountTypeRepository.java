package com.hdfinancas.hdfinancas.repository;

import com.hdfinancas.hdfinancas.model.AccountTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountTypeRepository extends JpaRepository<AccountTypeModel, Long> {

    Optional<AccountTypeModel> findById(long id);
}
