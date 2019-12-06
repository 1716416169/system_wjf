package com.wjf.system_wjf.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "other")
@ApiModel(value="其他的设备类",description="包含其他的设备实体")
public class Other {
    @Id
    @ApiModelProperty(hidden = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "id_other")
    @ApiModelProperty(value="其他设备的货号",name="id_other",example="1")
    private Integer id_other;

    @Column(name = "name")
    @ApiModelProperty(value="其他设备的名称",name="name",example="1")
    private String name;

    @Column(name = "price")
    @ApiModelProperty(value="其他设备的价格",name="id_other",example="1")
    private String price;

    @Column(name = "number")
    @ApiModelProperty(value="其他设备的数量",name="number",example="1")
    private String number;

    @Column(name = "remarks")
    @ApiModelProperty(value="其他设备的备注",name="remarks",example="1")
    private String remarks;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_other() {
        return id_other;
    }

    public void setId_other(Integer id_other) {
        this.id_other = id_other;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Other{" +
                "id=" + id +
                ", id_other=" + id_other +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", number='" + number + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
