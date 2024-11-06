package com.sky.mapper;

import com.sky.annotation.AutoFill;
import com.sky.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
* @author Administrator
* @description 针对表【employee(员工信息)】的数据库操作Mapper
* @createDate 2024-10-24 22:15:22
* @Entity com.sky.entity.Employee
*/
public interface EmployeeMapper extends BaseMapper<Employee> {

    @Select("select * from employee where username = #{username}")
    Employee getByUsername(@Param("username")String username);

    @Insert("insert into employee (name, username, password, phone, sex, id_number, create_time, update_time, create_user, update_user,status)" +
            "values (#{name},#{username},#{password},#{phone},#{sex},#{idNumber},#{createTime},#{updateTime},#{createUser},#{updateUser},#{status})")
    @AutoFill(value = OperationType.INSERT)
    int add(Employee employee);
}




