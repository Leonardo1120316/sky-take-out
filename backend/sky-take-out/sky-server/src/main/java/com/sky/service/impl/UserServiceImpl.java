package com.sky.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;
import com.sky.mapper.UserMapper;
import com.sky.service.UserService;
import com.sky.utils.WeChatLoginUtil;
import com.sky.vo.UserLoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【user(用户信息)】的数据库操作Service实现
* @createDate 2024-10-24 22:15:22
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    WeChatLoginUtil weChatLoginUtil;

    @Override
    public UserLoginVO login(UserLoginDTO userLoginDTO) {
        return null;
    }
}




