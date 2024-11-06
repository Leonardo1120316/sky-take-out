package com.sky.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 地址簿
 * @TableName address_book
 */
@TableName(value ="address_book")
@Data
public class AddressBook implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Long user_id;

    /**
     * 收货人
     */
    @TableField(value = "consignee")
    private String consignee;

    /**
     * 性别
     */
    @TableField(value = "sex")
    private String sex;

    /**
     * 手机号
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 省级区划编号
     */
    @TableField(value = "province_code")
    private String province_code;

    /**
     * 省级名称
     */
    @TableField(value = "province_name")
    private String province_name;

    /**
     * 市级区划编号
     */
    @TableField(value = "city_code")
    private String city_code;

    /**
     * 市级名称
     */
    @TableField(value = "city_name")
    private String city_name;

    /**
     * 区级区划编号
     */
    @TableField(value = "district_code")
    private String district_code;

    /**
     * 区级名称
     */
    @TableField(value = "district_name")
    private String district_name;

    /**
     * 详细地址
     */
    @TableField(value = "detail")
    private String detail;

    /**
     * 标签
     */
    @TableField(value = "label")
    private String label;

    /**
     * 默认 0 否 1是
     */
    @TableField(value = "is_default")
    private Integer is_default;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}