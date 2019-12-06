package com.wjf.system_wjf.repository;

import com.wjf.system_wjf.entity.Manger;
import com.wjf.system_wjf.entity.Other;
import com.wjf.system_wjf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MangerRepository extends JpaRepository<Manger,Integer>, JpaSpecificationExecutor<Manger> {
    public Manger findByUsernameAndPassword(String username, String password);
}
