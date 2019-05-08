package cn.royhsu.adminserver.admin.service.impl;

import cn.royhsu.adminserver.admin.entity.Dept;
import cn.royhsu.adminserver.admin.mapper.DeptMapper;
import cn.royhsu.adminserver.admin.service.DeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 机构管理 服务实现类
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {

}
