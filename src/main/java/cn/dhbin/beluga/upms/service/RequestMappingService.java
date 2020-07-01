package cn.dhbin.beluga.upms.service;

import cn.dhbin.beluga.upms.model.RequestMappingInfo;

import java.util.List;

/**
 * @author donghaibin
 * @date 2020/6/30
 */
public interface RequestMappingService {

    /**
     * 获取所有接口信息
     *
     * @return 所有接口信息
     */
    List<RequestMappingInfo> all();


}
