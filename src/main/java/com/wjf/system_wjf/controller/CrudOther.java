package com.wjf.system_wjf.controller;

import com.wjf.system_wjf.entity.Computer;
import com.wjf.system_wjf.entity.Other;
import com.wjf.system_wjf.server.impl.CrudOtherServerImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/others")
@CrossOrigin(origins = "*",maxAge = 3600)
public class CrudOther {
    @Autowired
    CrudOtherServerImpl crudOtherServer;

    @GetMapping("/selectOther")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="页码",dataType="Integer", paramType = "query",example="1"),
            @ApiImplicitParam(name="size",value="本页条数",dataType="Integer", paramType = "query",example="1")
    })
    public Page<Other> selectOther(Integer page, Integer size){
        Page<Other> others = crudOtherServer.selectOther(page ,size);
        System.out.println("查询的"+others);
        return others;
    }

    @PutMapping("/insertOther")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="页码",dataType="Integer", paramType = "query",example="1"),
            @ApiImplicitParam(name="size",value="本页条数",dataType="Integer", paramType = "query",example="1"),
    })
    public Page<Other> insertOther(Integer page, Integer size,Other other){
        Other other1 = crudOtherServer.insertOther(other);
        System.out.println("插入的"+other1);
        Page<Other> others = crudOtherServer.selectOther(page, size);
        return others;
    }

    @PostMapping("/updateOther")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="页码",dataType="Integer", paramType = "query",example="1"),
            @ApiImplicitParam(name="size",value="本页条数",dataType="Integer", paramType = "query",example="1"),
    })
    public Page<Other> updateOther(Integer page, Integer size,Other other){
        Other other1 = crudOtherServer.updateOther(other);
        System.out.println("更新的"+other1);
        Page<Other> others = crudOtherServer.selectOther(page, size);
        return others;
    }

    @DeleteMapping("/deleteOther")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="页码",dataType="Integer", paramType = "query",example="1"),
            @ApiImplicitParam(name="size",value="本页条数",dataType="Integer", paramType = "query",example="1"),
            @ApiImplicitParam(name="ids",value="数组",dataType="Integer[]", paramType = "query",example="1")
    })
    public Page<Other> deleteOther(Integer page, Integer size,@RequestParam(value = "ids[]")Integer ... ids){
        for (Integer id:ids) {
            System.out.println(id);
        }
        crudOtherServer.deleteOther(ids);
        Page<Other> others = crudOtherServer.selectOther(page, size);
        return others;
    }

    @DeleteMapping("/deleteOtherById")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="页码",dataType="Integer", paramType = "query",example="1"),
            @ApiImplicitParam(name="size",value="本页条数",dataType="Integer", paramType = "query",example="1"),
            @ApiImplicitParam(name="id",value="id",dataType="Integer", paramType = "query",example="1")
    })
    public Page<Other> deleteOtherById(Integer page, Integer size,Integer id){
        crudOtherServer.deleteOtherById(id);
        System.out.println("删除的"+id);
        Page<Other> others = crudOtherServer.selectOther(page, size);
        return others;
    }

    @GetMapping("/selectOtherByName")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="页码",dataType="Integer", paramType = "query",example="1"),
            @ApiImplicitParam(name="size",value="本页条数",dataType="Integer", paramType = "query",example="1"),
            @ApiImplicitParam(name="name",value="名字",dataType="String", paramType = "query",example="test")
    })
    public Page<Other> selectOtherByName(Integer page, Integer size, String name){
        System.out.println("查询名字"+name);
        Page<Other> others = crudOtherServer.selectOtherByName(page, size, name);
        System.out.println("名字查询："+others);
        return others;
    }

}
