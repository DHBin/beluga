package cn.dhbin.beluga.upms.model.param;

import cn.dhbin.minion.core.tool.converter.Convert;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * <p>
 * 字典项 Param
 * </p>
 *
 * @author DHB
 * @since 2020-10-16
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "SysDictItemParam", description = "字典项")
public class SysDictItemParam implements Convert {

    private static final long serialVersionUID = 1L;


    private Long id;


    @ApiModelProperty(value = "字典id")
    private Long dictId;


    @ApiModelProperty(value = "值")
    private String itemValue;


    @ApiModelProperty(value = "标签名")
    private String itemLabel;


    @ApiModelProperty(value = "描述")
    private String description;


    @ApiModelProperty(value = "排序编号")
    private Integer sortNum;

}