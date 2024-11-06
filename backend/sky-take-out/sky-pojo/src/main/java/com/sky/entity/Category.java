package com.sky.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 菜品及套餐分类
 * @TableName category
 */
@TableName(value ="category")
@Data
public class Category implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 类型   1 菜品分类 2 套餐分类
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 分类名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 顺序
     */
    @TableField(value = "sort")
    private Integer sort;

    /**
     * 分类状态 0:禁用，1:启用
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date create_time;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date update_time;

    /**
     * 创建人
     */
    @TableField(value = "create_user")
    private Long create_user;

    /**
     * 修改人
     */
    @TableField(value = "update_user")
    private Long update_user;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}