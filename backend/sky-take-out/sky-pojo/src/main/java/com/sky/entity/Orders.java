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
 * 订单表
 * @TableName orders
 */
@TableName(value ="orders")
@Data
public class Orders implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单号
     */
    @TableField(value = "number")
    private String number;

    /**
     * 订单状态 1待付款 2待接单 3已接单 4派送中 5已完成 6已取消 7退款
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 下单用户
     */
    @TableField(value = "user_id")
    private Long user_id;

    /**
     * 地址id
     */
    @TableField(value = "address_book_id")
    private Long address_book_id;

    /**
     * 下单时间
     */
    @TableField(value = "order_time")
    private Date order_time;

    /**
     * 结账时间
     */
    @TableField(value = "checkout_time")
    private Date checkout_time;

    /**
     * 支付方式 1微信,2支付宝
     */
    @TableField(value = "pay_method")
    private Integer pay_method;

    /**
     * 支付状态 0未支付 1已支付 2退款
     */
    @TableField(value = "pay_status")
    private Integer pay_status;

    /**
     * 实收金额
     */
    @TableField(value = "amount")
    private BigDecimal amount;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 手机号
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 用户名称
     */
    @TableField(value = "user_name")
    private String user_name;

    /**
     * 收货人
     */
    @TableField(value = "consignee")
    private String consignee;

    /**
     * 订单取消原因
     */
    @TableField(value = "cancel_reason")
    private String cancel_reason;

    /**
     * 订单拒绝原因
     */
    @TableField(value = "rejection_reason")
    private String rejection_reason;

    /**
     * 订单取消时间
     */
    @TableField(value = "cancel_time")
    private Date cancel_time;

    /**
     * 预计送达时间
     */
    @TableField(value = "estimated_delivery_time")
    private Date estimated_delivery_time;

    /**
     * 配送状态  1立即送出  0选择具体时间
     */
    @TableField(value = "delivery_status")
    private Integer delivery_status;

    /**
     * 送达时间
     */
    @TableField(value = "delivery_time")
    private Date delivery_time;

    /**
     * 打包费
     */
    @TableField(value = "pack_amount")
    private Integer pack_amount;

    /**
     * 餐具数量
     */
    @TableField(value = "tableware_number")
    private Integer tableware_number;

    /**
     * 餐具数量状态  1按餐量提供  0选择具体数量
     */
    @TableField(value = "tableware_status")
    private Integer tableware_status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}