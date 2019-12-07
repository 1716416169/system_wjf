package com.wjf.system_wjf.controller;

import com.wjf.system_wjf.entity.Manger;
import com.wjf.system_wjf.server.impl.CrudMangerServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(allowCredentials="true")
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
            return 10;
        }else {
            return 11;
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
    public Manger login(Manger manger, HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest){
        Manger manger1 = crudMangerServer.selectManger(manger);
        System.out.println(manger1);
        if(manger1 ==null){
            return null;
        }else {
            httpServletRequest.getSession().setAttribute(manger.getUsername(),manger.getPassword());
            httpServletRequest.getSession().setAttribute("ob","manger");
            System.out.println(httpServletRequest.getSession().getAttribute(manger.getUsername()));
            System.out.println(httpServletRequest.getSession().getAttribute("ob"));
            manger.setFlag("manger");
            return manger;
        }
    }
}
