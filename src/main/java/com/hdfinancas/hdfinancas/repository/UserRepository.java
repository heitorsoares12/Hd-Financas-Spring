package com.hdfinancas.hdfinancas.repository;

import com.hdfinancas.hdfinancas.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    Optional<UserModel> findById(long id);

    List<UserModel> findByNameContainsIgnoreCaseOrderByName(String name);

    List<UserModel> findByEmailStartsWithIgnoreCase(String email);
}
