package cn.royhsu.adminserver.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_role")
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 角色名称
     */
    @TableField("roleName")
    private String roleName;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否删除  -1：已删除  0：正常
     */
    @TableField("delFlag")
    private Integer delFlag;

    //非数据库字段
    private List<Menu> menus;

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
