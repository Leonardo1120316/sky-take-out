package com.sky.controller.userside;

import com.sky.dto.UserLoginDTO;
import com.sky.result.Result;
import com.sky.service.UserService;
import com.sky.vo.UserLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("用户接口")
@RequestMapping("/user/user")
@Slf4j
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public Result login(@RequestBody UserLoginDTO userLoginDTO){
//        log.info("code:{}",userLoginDTO.getCode());
//        UserLoginVO userLoginVO = userService.login(userLoginDTO);
        return Result.success();
    }
}
