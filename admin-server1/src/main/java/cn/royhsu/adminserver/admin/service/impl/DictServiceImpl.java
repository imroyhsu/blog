package cn.royhsu.adminserver.admin.service.impl;

import cn.royhsu.adminserver.admin.entity.Dict;
import cn.royhsu.adminserver.admin.mapper.DictMapper;
import cn.royhsu.adminserver.admin.service.DictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 字典表 服务实现类
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

}
