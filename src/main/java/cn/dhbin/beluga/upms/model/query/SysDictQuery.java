package cn.dhbin.beluga.upms.model.query;

import cn.dhbin.minion.core.tool.converter.Convert;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * <p>
 * 字典 Query
 * </p>
 *
 * @author DHB
 * @since 2020-10-16
 */
@Data
@EqualsAndHashCode
@ApiModel(value = "SysDictQuery", description = "字典")
public class SysDictQuery implements Convert {

    private static final long serialVersionUID = 1L;


    private Long id;


    @ApiModelProperty(value = "类型")
    private String type;


    @ApiModelProperty(value = "描述")
    private String description;

}