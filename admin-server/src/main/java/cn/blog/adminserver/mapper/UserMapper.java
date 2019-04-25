package cn.blog.adminserver.mapper;

import cn.royhsu.common.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-24
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
