package cn.royhsu.adminconsumer.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 字典表
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_dict")
public class Dict extends Model<Dict> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 数据值
     */
    private String value;

    /**
     * 标签名
     */
    private String label;

    /**
     * 类型
     */
    private String type;

    /**
     * 描述
     */
    private String description;

    /**
     * 排序（升序）
     */
    private BigDecimal sort;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 是否删除  -1：已删除  0：正常
     */
    @TableField("delFlag")
    private Integer delFlag;

    /**
     * 创建人
     */
    @TableField("createBy")
    private String createBy;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private Date createTime;

    /**
     * 更新人
     */
    @TableField("lastUpdateBy")
    private String lastUpdateBy;

    /**
     * 更新时间
     */
    @TableField("lastUpdateTime")
    private Date lastUpdateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
