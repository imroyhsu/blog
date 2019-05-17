package cn.royhsu.common.admin.entity;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Ethan Liu
 * @since 2019/5/17 20:29
 * 封装iPage的两个属性
 */

@AllArgsConstructor
@Getter
@Setter
public class Page {
    private IPage page;
    private Wrapper queryWrapper;
}
