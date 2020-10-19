package cn.dhbin.beluga.upms.entity;

import cn.dhbin.minion.core.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 字典
 * </p>
 *
 * @author DHB
 * @since 2020-10-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_dict")
@ApiModel(value = "SysDict对象", description = "字典")
public class SysDict extends BaseEntity {


    @TableId(value = "ID", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "类型")
    @TableField("type")
    private String type;

    @ApiModelProperty(value = "描述")
    @TableField("description")
    private String description;


}
