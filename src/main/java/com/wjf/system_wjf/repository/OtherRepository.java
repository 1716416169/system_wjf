package com.wjf.system_wjf.repository;

import com.wjf.system_wjf.entity.Computer;
import com.wjf.system_wjf.entity.Other;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OtherRepository extends JpaRepository<Other,Integer>, JpaSpecificationExecutor<Other> {
    Page<Other> findByNameLike(String name, Pageable pageable);
}
