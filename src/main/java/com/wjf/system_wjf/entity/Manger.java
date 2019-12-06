package com.wjf.system_wjf.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "manger")
@ApiModel(value="管理员",description="管理员")
public class Manger {

    @Id
    @ApiModelProperty(hidden = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "username")
    @ApiModelProperty(value="账号",name="账号",example="1")
    private Integer username;

    @Column(name = "password")
    @ApiModelProperty(value="密码",name="密码",example="1")
    private Integer password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsername() {
        return username;
    }

    public void setUsername(Integer username) {
        this.username = username;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Manger{" +
                "id=" + id +
                ", username=" + username +
                ", password=" + password +
                '}';
    }
}
