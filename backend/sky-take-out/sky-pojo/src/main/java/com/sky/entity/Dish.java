package com.sky.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 菜品
 * @TableName dish
 */
@TableName(value ="dish")
@Data
public class Dish implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 菜品名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 菜品分类id
     */
    @TableField(value = "category_id")
    private Long category_id;

    /**
     * 菜品价格
     */
    @TableField(value = "price")
    private BigDecimal price;

    /**
     * 图片
     */
    @TableField(value = "image")
    private String image;

    /**
     * 描述信息
     */
    @TableField(value = "description")
    private String description;

    /**
     * 0 停售 1 起售
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