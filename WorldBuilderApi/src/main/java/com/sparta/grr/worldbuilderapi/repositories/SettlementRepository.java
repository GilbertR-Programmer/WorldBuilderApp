package com.sparta.grr.worldbuilderapi.repositories;

import com.sparta.grr.worldbuilderapi.entities.Person;
import com.sparta.grr.worldbuilderapi.entities.Settlement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettlementRepository extends
        PagingAndSortingRepository<Settlement,Long>,
        CrudRepository<Settlement,Long>,
        JpaRepository<Settlement, Long> {
}