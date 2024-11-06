package com.sky.service;

import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sky.vo.UserLoginVO;

/**
* @author Administrator
* @description 针对表【user(用户信息)】的数据库操作Service
* @createDate 2024-10-24 22:15:22
*/
public interface UserService extends IService<User> {
    UserLoginVO login(UserLoginDTO userLoginDTO);
}
