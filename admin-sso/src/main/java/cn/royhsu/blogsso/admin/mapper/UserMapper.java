package cn.royhsu.blogsso.admin.mapper;

import cn.royhsu.common.admin.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */

public interface UserMapper extends BaseMapper<User> {


    /**
     * 通过Id查询User,关联查询role和permission
     */
    @Select("select sys_user.id id,username,password,salt,email,mobile,status,deptId,sys_user.delFlag FROM sys_user where username = #{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "salt", column = "salt"),
            @Result(property = "email", column = "email"),
            @Result(property = "mobile", column = "mobile"),
            @Result(property = "status", column = "status"),
            @Result(property = "deptId", column = "deptId"),
            @Result(property = "delFlag", column = "sys_user.delFlag")
})
    User findByName(@PathVariable(value = "username") Serializable username);
}
