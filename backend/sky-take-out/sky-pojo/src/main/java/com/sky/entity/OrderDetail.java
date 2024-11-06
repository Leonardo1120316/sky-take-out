package com.sky.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 订单明细表
 * @TableName order_detail
 */
@TableName(value ="order_detail")
@Data
public class OrderDetail implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 名字
     */
    @TableField(value = "name")
    private String name;

    /**
     * 图片
     */
    @TableField(value = "image")
    private String image;

    /**
     * 订单id
     */
    @TableField(value = "order_id")
    private Long order_id;

    /**
     * 菜品id
     */
    @TableField(value = "dish_id")
    private Long dish_id;

    /**
     * 套餐id
     */
    @TableField(value = "setmeal_id")
    private Long setmeal_id;

    /**
     * 口味
     */
    @TableField(value = "dish_flavor")
    private String dish_flavor;

    /**
     * 数量
     */
    @TableField(value = "number")
    private Integer number;

    /**
     * 金额
     */
    @TableField(value = "amount")
    private BigDecimal amount;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}