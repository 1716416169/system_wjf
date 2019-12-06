package com.wjf.system_wjf.server.impl;

import com.wjf.system_wjf.entity.User;
import com.wjf.system_wjf.repository.UserRepository;
import com.wjf.system_wjf.server.CrudUserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class CrudUserServerImpl implements CrudUserServer {

    @Autowired
    UserRepository userRepository;

    @Override
    public User selectUser(User user) {
        User byUsernameAndPassword = userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
        if (byUsernameAndPassword!=null){
            System.out.println("登录成功");
            return byUsernameAndPassword;
        }else {
            System.out.println("账户不存在");
            return null;
        }
    }

    @Override
    public User insertUser(User user) {
        User byUsernameAndPassword = userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
        if(byUsernameAndPassword==null){
            User save = userRepository.save(user);
            System.out.println("注册成功");
            return save;
        }else {
            System.out.println("账号已存在");
            return null;
        }
    }
}
