package com.wjf.system_wjf.controller;

import com.wjf.system_wjf.entity.User;
import com.wjf.system_wjf.server.impl.CrudUserServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(allowCredentials="true")
@RequestMapping("/login")
public class Login {

    @Autowired
    CrudUserServerImpl crudUserServer;

    @PutMapping("/register")
    public Integer register(User user){
        System.out.println("注册的账号："+user.getUsername());
        User user1 = crudUserServer.insertUser(user);
        System.out.println("创建的用户："+user1);
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
    public User login(User user, HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest){
        User user1 = crudUserServer.selectUser(user);
        if(user1==null){
            return null;
        }else {
            httpServletRequest.getSession().setAttribute(user.getUsername(),user.getPassword());
            httpServletRequest.getSession().setAttribute("ob","user");
            System.out.println(httpServletRequest.getSession().getAttribute(user.getUsername()));
            System.out.println(httpServletRequest.getSession().getAttribute("ob"));
            user.setFlag("user");
            return user;
        }

    }

}
