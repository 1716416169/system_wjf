package com.wjf.system_wjf.repository;

import com.wjf.system_wjf.entity.Computer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface ComputerRepository extends JpaRepository<Computer,Integer>, JpaSpecificationExecutor<Computer> {
    Page<Computer> findByNameLike(String name, Pageable pageable);
}
