package cn.royhsu.adminserver.admin.mapper;

import cn.royhsu.common.admin.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 菜单管理 Mapper 接口
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */
public interface MenuMapper extends BaseMapper<Menu> {
    @Select("select sys_menu.id menuId,name,parentId,url,perms,type,icon,orderNum,sys_menu.delFlag FROM sys_menu where sys_menu.id in " +
            "(select sys_role_menu.menuId from sys_role_menu where roleId = #{roleId} )")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "menuName", column = "name"),
            @Result(property = "parentId", column = "parentId"),
            @Result(property = "url", column = "url"),
            @Result(property = "perms", column = "perms"),
            @Result(property = "type", column = "type"),
            @Result(property = "icon", column = "icon"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "delFlag", column = "sys_menu.delFlag"),
    })
    List<Menu> findByRoleId(@PathVariable(value = "roleId") Serializable roleId);

    @Select("select sys_menu.id menuId,name,parentId,url,perms,type,icon,orderNum,sys_menu.delFlag FROM sys_menu where sys_menu.id in " +
            "(select sys_role_menu.menuId from sys_role_menu where roleId in (select sys_user_role.roleId from sys_user_role where userId = #{userId}) )")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "menuName", column = "name"),
            @Result(property = "parentId", column = "parentId"),
            @Result(property = "url", column = "url"),
            @Result(property = "perms", column = "perms"),
            @Result(property = "type", column = "type"),
            @Result(property = "icon", column = "icon"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "delFlag", column = "sys_menu.delFlag"),
    })
    List<Menu> findByUserId(@PathVariable(value = "userId") Serializable userId);

    @Select("select sys_menu.id menuId,name,parentId,url,perms,type,icon,orderNum,sys_menu.delFlag FROM sys_menu where sys_menu.id in " +
            "(select sys_role_menu.menuId from sys_role_menu where roleId in (select sys_user_role.roleId from sys_user_role where userId = (select id from sys_user where username = #{username})))")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "menuName", column = "name"),
            @Result(property = "parentId", column = "parentId"),
            @Result(property = "url", column = "url"),
            @Result(property = "perms", column = "perms"),
            @Result(property = "type", column = "type"),
            @Result(property = "icon", column = "icon"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "delFlag", column = "sys_menu.delFlag"),
    })
    List<Menu> findByUsername(@PathVariable(value = "username") String username);
}
