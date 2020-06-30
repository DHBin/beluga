package cn.dhbin.beluga.service.impl;

import cn.dhbin.beluga.entity.SysRolePerm;
import cn.dhbin.beluga.mapper.SysUserPermMapper;
import cn.dhbin.beluga.service.SysRolePermService;
import cn.dhbin.minion.core.mybatis.service.MinionServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
@Service
public class SysRolePermServiceImpl extends MinionServiceImpl<SysUserPermMapper, SysRolePerm> implements SysRolePermService {

    @Override
    public List<SysRolePerm> getByRoleId(Long roleId) {
        return lambdaQuery().eq(SysRolePerm::getRid, roleId).list();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateByRoleId(Long roleId, List<String> perms) {
        this.remove(new LambdaQueryWrapper<SysRolePerm>().eq(SysRolePerm::getRid, roleId));
        List<SysRolePerm> rolePermList = perms.stream().map(permId -> {
            SysRolePerm sysRolePerm = new SysRolePerm();
            sysRolePerm.setPid(permId);
            sysRolePerm.setRid(roleId);
            return sysRolePerm;
        }).collect(Collectors.toList());
        this.saveBatch(rolePermList);
    }
}
