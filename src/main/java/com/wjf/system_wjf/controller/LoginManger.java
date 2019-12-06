package com.wjf.system_wjf.controller;

import com.wjf.system_wjf.entity.Manger;
import com.wjf.system_wjf.server.impl.CrudMangerServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/loginManger")
public class LoginManger {

    @Autowired
    CrudMangerServerImpl crudMangerServer;

    @PutMapping("/register")
    public Integer register(Manger manger){
        System.out.println(manger.getUsername());
        Manger manger1= crudMangerServer.insertManger(manger);
        System.out.println(manger1);
        if(manger1==null){
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
    public Integer login(Manger manger){
        Manger manger1 = crudMangerServer.selectManger(manger);
        System.out.println(manger1);
        if(manger1 ==null){
            return 0;
        }else {
            return 1;
        }

    }
}
