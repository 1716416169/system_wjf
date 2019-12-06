package com.wjf.system_wjf.controller;

import com.wjf.system_wjf.entity.Computer;
import com.wjf.system_wjf.server.impl.CrudComputerServerImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/computer")
public class CrudComputer {//pom文件jdbc starter 和 mysql-connect-java starter添加错误

    @Autowired
    CrudComputerServerImpl crudComputerServer;

    @GetMapping("/selectComputer")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="页码",dataType="Integer", paramType = "query",example="1"),
            @ApiImplicitParam(name="size",value="本页条数",dataType="Integer", paramType = "query",example="1")
    })
    public Page<Computer> selectComputer(@RequestParam(name = "page") Integer page,@RequestParam(name = "size")  Integer size){
        Page<Computer> computers = crudComputerServer.selectComputer(page ,size);
        System.out.println("查询的"+computers);
        return computers;
    }

    @PutMapping("/insertComputer")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="页码",dataType="Integer", paramType = "query",example="1"),
            @ApiImplicitParam(name="size",value="本页条数",dataType="Integer", paramType = "query",example="1"),
  })
    public Page<Computer> insertComputer(Integer page, Integer size,Computer computer){
        Computer computer1 = crudComputerServer.insertComputer(computer);
        System.out.println("插入的"+computer1);
        Page<Computer> computers = crudComputerServer.selectComputer(page, size);
        return computers;
    }

    @PostMapping("/updateComputer")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="页码",dataType="Integer", paramType = "query",example="1"),
            @ApiImplicitParam(name="size",value="本页条数",dataType="Integer", paramType = "query",example="1"),
    })
    public Page<Computer> updateComputer(Integer page, Integer size,Computer computer){
        Computer computer1 = crudComputerServer.updateComputer(computer);
        System.out.println("更新的"+computer1);
        Page<Computer> computers = crudComputerServer.selectComputer(page, size);
        return computers;
    }

    @DeleteMapping("/deleteComputer")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="页码",dataType="Integer", paramType = "query",example="1"),
            @ApiImplicitParam(name="size",value="本页条数",dataType="Integer", paramType = "query",example="1"),
            @ApiImplicitParam(name="ids",value="数组",dataType="Integer[]", paramType = "query",example="1")
    })
    public Page<Computer> deleteComputer(Integer page, Integer size,Integer ... ids){
        Page<Computer> computer1 = crudComputerServer.deleteComputer(ids);
        System.out.println("删除的复数"+computer1);
        Page<Computer> computers = crudComputerServer.selectComputer(page, size);
        return computers;
    }

    @DeleteMapping("/deleteComputerById")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="页码",dataType="Integer", paramType = "query",example="1"),
            @ApiImplicitParam(name="size",value="本页条数",dataType="Integer", paramType = "query",example="1"),
            @ApiImplicitParam(name="id",value="id",dataType="Integer", paramType = "query",example="1")
    })
    public Page<Computer> deleteComputerById(Integer page, Integer size,Integer id){
        crudComputerServer.deleteComputerById(id);
        System.out.println("删除的"+id);
        Page<Computer> computers = crudComputerServer.selectComputer(page, size);
        return computers;
    }

    @GetMapping("/selectComputerByName")
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="页码",dataType="Integer", paramType = "query",example="1"),
            @ApiImplicitParam(name="size",value="本页条数",dataType="Integer", paramType = "query",example="1"),
            @ApiImplicitParam(name="name",value="名字",dataType="String", paramType = "query",example="test")
    })
    public Page<Computer> selectComputerByName(Integer page,Integer size,String name){
        Page<Computer> computers = crudComputerServer.selectComputerByName(page, size, name);
        return computers;
    }

}
