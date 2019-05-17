package cn.royhsu.adminserver.admin.service.impl;

import cn.royhsu.adminserver.admin.mapper.RoleDeptMapper;
import cn.royhsu.adminserver.admin.service.RoleDeptService;
import cn.royhsu.common.admin.entity.RoleDept;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色与机构对应关系 服务实现类
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */
@Service
public class RoleDeptServiceImpl extends ServiceImpl<RoleDeptMapper, RoleDept> implements RoleDeptService {

}
