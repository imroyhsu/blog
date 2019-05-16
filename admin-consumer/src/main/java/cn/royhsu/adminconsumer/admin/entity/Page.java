package cn.royhsu.adminconsumer.admin.entity;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Ethan Liu
 * @since 2019/5/16 22:44
 * page包装类，包装iPage和quarry对象
 */
@AllArgsConstructor
@Data
public class Page {
    private IPage iPage;
    private Wrapper wrapper;
}
