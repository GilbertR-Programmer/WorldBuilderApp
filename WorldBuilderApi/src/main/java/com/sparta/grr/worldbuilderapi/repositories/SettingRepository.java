package com.sparta.grr.worldbuilderapi.repositories;

import com.sparta.grr.worldbuilderapi.entities.ParentChild;
import com.sparta.grr.worldbuilderapi.entities.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettingRepository extends
        PagingAndSortingRepository<Setting,Long>,
        CrudRepository<Setting,Long>,
        JpaRepository<Setting,Long> {
}
