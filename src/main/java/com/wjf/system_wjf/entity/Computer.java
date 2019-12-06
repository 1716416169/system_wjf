package com.wjf.system_wjf.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import javax.persistence.*;

@Entity
@Table(name = "Computer")
@ApiModel(value="计算机类",description="包含计算机实体")
public class Computer {
    @Id         //导包问题
    @ApiModelProperty(hidden = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "id_computer")
    @ApiModelProperty(value="计算机货号",name="id_computer",example="1")
    private Integer id_computer;

    @Column(name = "name")
    @ApiModelProperty(value="计算机名称",name="name",example="test")
    private String name;

    @Column(name = "date")
    @ApiModelProperty(value="生产日期",name="date",example="test")
    private String date;

    @Column(name = "price")
    @ApiModelProperty(value="价格",name="price",example="test")
    private String price;

    @Column(name = "number")
    @ApiModelProperty(value="数量",name="number",example="test")
    private String number;

    @Column(name = "fro")
    @ApiModelProperty(value="生产商",name="fro",example="test")
    private String fro;

    @Column(name = "configs")
    @ApiModelProperty(value="配置信息",name="configs",example="test")
    private String configs;

    public Integer getId_computer() {
        return id_computer;
    }

    public void setId_computer(Integer id_computer) {
        this.id_computer = id_computer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFro() {
        return fro;
    }

    public void setFro(String fro) {
        this.fro = fro;
    }

    public String getConfigs() {
        return configs;
    }

    public void setConfigs(String configs) {
        this.configs = configs;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", id_computer=" + id_computer +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", price='" + price + '\'' +
                ", number='" + number + '\'' +
                ", fro='" + fro + '\'' +
                ", configs='" + configs + '\'' +
                '}';
    }
}
