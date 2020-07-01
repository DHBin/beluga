package cn.dhbin.beluga.upms.service.impl;

import cn.dhbin.beluga.upms.entity.SysMenuPerm;
import cn.dhbin.beluga.upms.mapper.SysMenuPermMapper;
import cn.dhbin.beluga.upms.service.SysMenuPermService;
import cn.dhbin.minion.core.mybatis.service.MinionServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author donghaibin
 * @date 2020/3/20
 */
@Service
public class SysMenuPermServiceImpl extends MinionServiceImpl<SysMenuPermMapper, SysMenuPerm> implements SysMenuPermService {


    @Override
    public List<SysMenuPerm> getByMenuId(Long menuId) {
        return lambdaQuery().eq(SysMenuPerm::getMid, menuId).list();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateByMenuId(Long menuId, List<String> perms) {
        this.remove(new LambdaQueryWrapper<SysMenuPerm>().eq(SysMenuPerm::getMid, menuId));
        List<SysMenuPerm> rolePermList = perms.stream().map(permId -> {
            SysMenuPerm sysMenuPerm = new SysMenuPerm();
            sysMenuPerm.setPid(permId);
            sysMenuPerm.setMid(menuId);
            return sysMenuPerm;
        }).collect(Collectors.toList());
        this.saveBatch(rolePermList);
    }


}
