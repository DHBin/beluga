package cn.dhbin.beluga.upms.service.impl;

import cn.dhbin.beluga.upms.entity.SysMenuPerm;
import cn.dhbin.beluga.upms.entity.SysPerm;
import cn.dhbin.beluga.upms.entity.SysRolePerm;
import cn.dhbin.beluga.upms.mapper.SysPermMapper;
import cn.dhbin.beluga.upms.model.RequestMappingInfo;
import cn.dhbin.beluga.upms.model.dto.SysPermDto;
import cn.dhbin.beluga.upms.service.RequestMappingService;
import cn.dhbin.beluga.upms.service.SysMenuPermService;
import cn.dhbin.beluga.upms.service.SysPermService;
import cn.dhbin.beluga.upms.service.SysRolePermService;
import cn.dhbin.beluga.util.AopUtil;
import cn.dhbin.minion.core.mybatis.model.PageModel;
import cn.dhbin.minion.core.mybatis.service.MinionServiceImpl;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
@Service
@RequiredArgsConstructor
public class SysPermServiceImpl extends MinionServiceImpl<SysPermMapper, SysPerm> implements SysPermService {

    private final SysRolePermService sysRolePermService;

    private final SysMenuPermService sysMenuPermService;

    private static final String CACHE_NAME = "sysPerm";
    private final RequestMappingService requestMappingService;
    private final CacheManager cacheManager;

    @Override
    @Cacheable(cacheNames = CACHE_NAME, key = "#id")
    public SysPerm getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    public List<SysPerm> getByRoleId(Long roleId) {
        return sysRolePermService.getByRoleId(roleId)
                .stream()
                .map(sysUserPerm -> AopUtil.getCurrentProxy(SysPermService.class).getById(sysUserPerm.getPid()))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Override
    public List<SysPerm> getByMenuId(Long menuId) {
        return sysMenuPermService.getByMenuId(menuId)
                .stream()
                .map(sysMenuPerm -> {
                    SysPermService sysPermService = AopUtil.getCurrentProxy(SysPermService.class);
                    return sysPermService.getById(sysMenuPerm.getPid());
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

    }

    @Override
    @CacheEvict(cacheNames = CACHE_NAME, key = "#id")
    public boolean removeById(Serializable id) {
        this.sysRolePermService.remove(new LambdaQueryWrapper<SysRolePerm>().eq(SysRolePerm::getPid, id));
        this.sysMenuPermService.remove(new LambdaQueryWrapper<SysMenuPerm>().eq(SysMenuPerm::getPid, id));
        return super.removeById(id);
    }

    @Override
    @CachePut(cacheNames = CACHE_NAME, key = "#entity.id")
    public SysPerm updateByIdAndReturn(SysPerm entity) {
        return super.updateByIdAndReturn(entity);
    }

    @Override
    @Cacheable(cacheNames = CACHE_NAME, key = "'all'")
    public List<SysPermDto> all() {
        return this.lambdaQuery().list().stream().map(sysPerm -> sysPerm.convert(SysPermDto.class)).collect(Collectors.toList());
    }

    @Override
    @CacheEvict(cacheNames = CACHE_NAME, key = "'all'")
    @Transactional(rollbackFor = Exception.class)
    public void reload() {
        Cache cache = Objects.requireNonNull(cacheManager.getCache(CACHE_NAME));
        this.list().forEach(sysPerm -> {
            cache.evict(sysPerm.getId());
        });
        this.baseMapper.delete(new QueryWrapper<>());
        List<RequestMappingInfo> mappingInfos = requestMappingService.all();
        List<SysPerm> sysPermList = mappingInfos.stream().map(requestMappingInfo -> {
            SysPerm sysPerm = new SysPerm();
            sysPerm.setId(requestMappingInfo.getId());
            sysPerm.setOwn(requestMappingInfo.getOwn());
            sysPerm.setPath(String.join(StrUtil.COMMA, requestMappingInfo.getPath()));
            sysPerm.setMethod(String.join(StrUtil.COMMA, requestMappingInfo.getMethod()));
            sysPerm.setName(requestMappingInfo.getName());
            sysPerm.setDescription(requestMappingInfo.getDescription());
            sysPerm.setAuthorizations(requestMappingInfo.getAuthorizations());
            return sysPerm;
        }).peek(sysPerm -> cache.put(sysPerm.getId(), sysPerm)).collect(Collectors.toList());
        this.saveOrUpdateBatch(sysPermList);
    }

    @Override
    public IPage<SysPermDto> page(PageModel<SysPerm> pageModel) {
        return this.page(pageModel.convert(), new LambdaQueryWrapper<SysPerm>().orderByDesc(SysPerm::getAuthorizations))
                .convert(sysPerm -> sysPerm.convert(SysPermDto.class));
    }


}
