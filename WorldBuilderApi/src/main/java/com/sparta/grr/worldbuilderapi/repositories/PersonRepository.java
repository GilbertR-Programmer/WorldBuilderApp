package com.sparta.grr.worldbuilderapi.repositories;

import com.sparta.grr.worldbuilderapi.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends
        PagingAndSortingRepository<Person,Long>,
        CrudRepository<Person,Long>,
        JpaRepository<Person, Long> {
}