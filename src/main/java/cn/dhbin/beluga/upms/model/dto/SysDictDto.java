package cn.dhbin.beluga.upms.model.dto;

import cn.dhbin.minion.core.tool.converter.Convert;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 字典 Dto
 * </p>
 *
 * @author DHB
 * @since 2020-10-16
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "SysDictDto", description = "字典")
public class SysDictDto implements Convert {

    private static final long serialVersionUID = 1L;


    private Long id;


    @ApiModelProperty(value = "类型")
    private String type;


    @ApiModelProperty(value = "描述")
    private String description;

}