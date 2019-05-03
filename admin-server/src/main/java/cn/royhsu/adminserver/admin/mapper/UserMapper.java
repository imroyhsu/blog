package cn.royhsu.adminserver.admin.mapper;

import cn.royhsu.adminserver.admin.entity.User;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */

public interface UserMapper extends BaseMapper<User> {


    @Select("select id,username,password,salt,email,mobile,status,deptId,delFlag FROM sys_user")
    IPage<User> findPage(IPage<User> page, @Param(Constants.WRAPPER)Wrapper<User> queryWrapper);



    @Select("select sys_user.id id,username,password,salt,email,mobile,status,deptId,sys_user.delFlag FROM sys_user where id in " +
            "(select sys_user_role.userId from sys_user_role where userId = #{userId} )")
    @Results({
            @Result(id = true,property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "salt", column = "salt"),
            @Result(property = "email", column = "email"),
            @Result(property = "mobile", column = "mobile"),
            @Result(property = "status",column = "status"),
            @Result(property = "deptId", column = "deptId"),
            @Result(property = "delFlag",column = "sys_user.delFlag"),
            @Result(property = "roles",column ="id",javaType = List.class,
            many = @Many(select = "cn.royhsu.adminserver.admin.mapper.RoleMapper.findByUserId"))
    })
    User findById(@PathVariable(value = "userId") Serializable userId);
}
