package com.wjf.system_wjf.repository;

import com.wjf.system_wjf.entity.Other;
import com.wjf.system_wjf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {
    public User findByUsernameAndPassword(String username,String password);
}
