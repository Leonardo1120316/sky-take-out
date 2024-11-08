package com.sky.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sky.entity.Orders;
import com.sky.mapper.OrdersMapper;
import com.sky.service.OrdersService;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【orders(订单表)】的数据库操作Service实现
* @createDate 2024-10-24 22:15:22
*/
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders>
    implements OrdersService {

}




