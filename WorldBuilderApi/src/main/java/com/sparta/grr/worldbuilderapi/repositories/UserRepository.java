package com.sparta.grr.worldbuilderapi.repositories;


import com.sparta.grr.worldbuilderapi.entities.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends
        JpaRepository<MyUser, Long>,
        PagingAndSortingRepository<MyUser, Long>,
        CrudRepository<MyUser, Long> {
    Optional<MyUser> findByUsername(String username);
}
