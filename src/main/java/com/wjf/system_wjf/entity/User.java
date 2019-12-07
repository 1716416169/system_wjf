package com.wjf.system_wjf.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;

import javax.persistence.*;

@Entity
@Table(name = "user")
@ApiModel(value="实验人员",description="实验人员")
public class User {
    @Id
    @ApiModelProperty(hidden = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "flag")
    @ApiModelProperty(value="标识",name="flag",example="1")
    private String flag;

    @Column(name = "username")
    @ApiModelProperty(value="账号",name="username",example="1")
    private String username;

    @Column(name = "password")
    @ApiModelProperty(value="密码",name="password",example="1")
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", flag='" + flag + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
