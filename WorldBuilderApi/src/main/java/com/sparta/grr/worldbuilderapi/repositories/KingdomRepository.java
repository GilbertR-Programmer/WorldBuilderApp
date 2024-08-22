package com.sparta.grr.worldbuilderapi.repositories;

import com.sparta.grr.worldbuilderapi.entities.Kingdom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KingdomRepository extends
        PagingAndSortingRepository<Kingdom, Long>,
        CrudRepository<Kingdom,Long>,
        JpaRepository<Kingdom,Long> {
}
