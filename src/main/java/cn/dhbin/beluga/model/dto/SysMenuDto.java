package cn.dhbin.beluga.model.dto;

import cn.dhbin.beluga.model.enums.MenuType;
import cn.dhbin.beluga.util.TreeNode;
import cn.dhbin.minion.core.tool.converter.Convert;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author donghaibin
 * @date 2020/3/18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysMenuDto extends TreeNode implements Convert {

    private static final long serialVersionUID = -797162840129744190L;

    private Long id;

    private String path;

    private String component;

    private Object meta;

    private String icon;

    private String label;

    private Integer orderNum;

    private Integer parentNum;

    private Integer num;

    private MenuType type;

    private List<String> perms;

}
