package com.wjf.system_wjf.controller;

import com.wjf.system_wjf.entity.User;
import com.wjf.system_wjf.repository.UserRepository;
import com.wjf.system_wjf.server.CrudUserServer;
import com.wjf.system_wjf.server.impl.CrudUserServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class Login {

    @Autowired
    CrudUserServerImpl crudUserServer;

    @PutMapping("/register")
    public Integer register(User user){
        System.out.println(user.getUsername());
        User user1 = crudUserServer.insertUser(user);
        System.out.println(user1);
        if(user1==null){
            return 0;
        }else {
            return 1;
        }
    }

    @GetMapping("/failed")
    public Map<String, String> requestFailed(){

        Map<String, String> map = new HashMap<>();
        map.put("code", "-1");
        map.put("msg", "请求错误");
        return map;
    }

    @GetMapping("/login")
    public Integer login(User user){
        User user1 = crudUserServer.selectUser(user);
        System.out.println(user1);
        if(user1==null){
            return 0;
        }else {
            return 1;
        }

    }

}
