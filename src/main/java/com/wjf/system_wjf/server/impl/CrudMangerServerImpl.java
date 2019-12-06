package com.wjf.system_wjf.server.impl;

import com.wjf.system_wjf.entity.Manger;
import com.wjf.system_wjf.entity.User;
import com.wjf.system_wjf.repository.MangerRepository;
import com.wjf.system_wjf.server.CrudMangerServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrudMangerServerImpl implements CrudMangerServer {

    @Autowired
    MangerRepository mangerRepository;
    @Override
    public Manger selectManger(Manger manger) {
        Manger UsernameAndPassword = mangerRepository.findByUsernameAndPassword(manger.getUsername(),manger.getPassword());
        if (UsernameAndPassword!=null){
            System.out.println("登录成功");
            return UsernameAndPassword;
        }else {
            System.out.println("账户不存在");
            return null;
        }
    }

    @Override
    public Manger insertManger(Manger manger) {
        Manger byUsernameAndPassword =mangerRepository.findByUsernameAndPassword(manger.getUsername(),manger.getPassword());
        if(byUsernameAndPassword==null){
            Manger save = mangerRepository.save(manger);
            System.out.println("注册成功");
            return save;
        }else {
            System.out.println("账号已存在");
            return null;
        }
    }
}
