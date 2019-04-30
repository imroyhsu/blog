package cn.royhsu.adminserver.admin.mapper;

import cn.royhsu.adminserver.admin.entity.User;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */
public interface UserMapper extends BaseMapper<User> {
    @Override
    @Select("select id,username,password,salt,email,mobile,status,deptId,delFlag FROM sys_user")
    default IPage<User> selectPage(IPage<User> page, Wrapper<User> queryWrapper) {
        return null;
    }
    @Select("SELECT id,username,password,salt,email,mobile,status,deptId,dept_name,delFlag,role_names,user_roles FROM sys_user WHERE id=?")
    @Override
    default User selectOne(Wrapper<User> queryWrapper) {
        return null;
    }
}
