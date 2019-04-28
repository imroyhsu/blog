package cn.royhsu.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色与机构对应关系
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_role_dept")
public class RoleDept extends Model<RoleDept> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 角色ID
     */
    @TableField("roleId")
    private Long roleId;

    /**
     * 机构ID
     */
    @TableField("deptId")
    private Long deptId;

    /**
     * 创建人
     */
    @TableField("createBy")
    private String createBy;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    @TableField("lastUpdateBy")
    private String lastUpdateBy;

    /**
     * 更新时间
     */
    @TableField("lastUpdateTime")
    private LocalDateTime lastUpdateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
