package cn.royhsu.adminserver.admin.mapper;

import cn.royhsu.adminserver.admin.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 角色 Mapper 接口
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */
public interface RoleMapper extends BaseMapper<Role> {
    @Select("select sys_role.id id,name,remark,sys_role.delFlag FROM sys_role where sys_role.id in " +
            "(select sys_user_role.roleId from sys_user_role where userId = #{userId} )")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "name"),
            @Result(property = "remark", column = "remark"),
            @Result(property = "delFlag", column = "sys_role.delFlag"),
            @Result(property = "menus", column = "id", javaType = List.class,
                    many = @Many(select = "cn.royhsu.adminserver.admin.mapper.MenuMapper.findByRoleId"))
    })
    List<Role> findByUserId(@PathVariable(value = "userId") Serializable userId);

}
