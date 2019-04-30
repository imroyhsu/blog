package cn.royhsu.adminserver.admin.entity;

import lombok.Data;

import java.util.Date;

/**
 * 基础模型
 * @author Ethan Liu
 * @since 2019/4/30 15:41
 */
@Data
public class BaseModel {

    private Long id;

    private String createBy;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;
}
