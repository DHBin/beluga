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
 * 字典项
 * </p>
 *
 * @author DHB
 * @since 2020-10-16
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_dict_item")
@ApiModel(value = "SysDictItem对象", description = "字典项")
public class SysDictItem extends BaseEntity {


    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "字典id")
    @TableField("dict_id")
    private Long dictId;

    @ApiModelProperty(value = "值")
    @TableField("item_value")
    private String itemValue;

    @ApiModelProperty(value = "标签名")
    @TableField("item_label")
    private String itemLabel;

    @ApiModelProperty(value = "描述")
    @TableField("description")
    private String description;

    @ApiModelProperty(value = "排序编号")
    @TableField("sort_num")
    private Integer sortNum;


}
