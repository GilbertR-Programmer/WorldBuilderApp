package com.sparta.grr.worldbuilderapi.repositories;

import com.sparta.grr.worldbuilderapi.entities.ParentChild;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentChildRepository extends
        PagingAndSortingRepository<ParentChild,Long>,
        CrudRepository<ParentChild,Long>,
        JpaRepository<ParentChild,Long> {
}
