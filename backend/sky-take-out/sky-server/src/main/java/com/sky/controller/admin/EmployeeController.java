package com.sky.controller.admin;

import com.sky.constant.MessageConstant;
import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.entity.Employee;
import com.sky.properties.JwtProperties;
import com.sky.result.Result;
import com.sky.service.EmployeeService;
import com.sky.utils.IsSuccessOperation;
import com.sky.utils.JwtUtil;
import com.sky.vo.EmployeeLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/employee")
@Api(tags="员工接口")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private JwtProperties jwtProperties;

    @ApiOperation("员工新增")
    @PostMapping
    public Result add(@RequestBody EmployeeDTO employeeDTO){
        int result = employeeService.add(employeeDTO);
        log.info("result{}",result);
        return IsSuccessOperation.isSuccess(result, MessageConstant.ADD_ERROR);
    }

    @ApiOperation("登录")
    @PostMapping("/login")
    public Result<EmployeeLoginVO> login(@RequestBody EmployeeLoginDTO employeeLoginDTO){
        log.info("员工登录：{}", employeeLoginDTO);
        //md5加密
        log.info(DigestUtils.md5DigestAsHex(employeeLoginDTO.getPassword().getBytes()));
        employeeLoginDTO.setPassword(DigestUtils.md5DigestAsHex(employeeLoginDTO.getPassword().getBytes()));
        Employee employee = employeeService.login(employeeLoginDTO);
        //员工登录返回的数据格式
        EmployeeLoginVO employeeLoginVO = EmployeeLoginVO.builder().id(employee.getId())
                .userName(employee.getUsername())
                .name(employee.getName())
                .token(JwtUtil.getToken(employee.getId()))
                .build();
        return Result.success(employeeLoginVO);
    }


}
