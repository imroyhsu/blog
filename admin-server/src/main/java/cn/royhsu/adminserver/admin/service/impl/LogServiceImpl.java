package cn.royhsu.adminserver.admin.service.impl;

import cn.royhsu.adminserver.admin.entity.Log;
import cn.royhsu.adminserver.admin.mapper.LogMapper;
import cn.royhsu.adminserver.admin.service.LogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统日志 服务实现类
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {

}
