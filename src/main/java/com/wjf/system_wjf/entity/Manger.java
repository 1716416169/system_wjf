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

    @Column(name = "flag")
    @ApiModelProperty(value="标识",name="flag",example="1")
    private String flag;

    @Column(name = "username")
    @ApiModelProperty(value="账号",name="账号",example="1")
    private String username;

    @Column(name = "password")
    @ApiModelProperty(value="密码",name="密码",example="1")
    private String password;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

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

    @Override
    public String toString() {
        return "Manger{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
