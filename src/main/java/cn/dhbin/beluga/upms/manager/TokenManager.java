package cn.dhbin.beluga.upms.manager;

/**
 * Token管理类
 *
 * @author donghaibin
 * @date 2020/7/7
 */
public interface TokenManager<T> {


    /**
     * 存入token
     *
     * @param token  token
     * @param detail 详细信息，比如用户信息
     */
    void save(String token, T detail);

    /**
     * 加载detail
     *
     * @param token token
     * @return 详细信息
     */
    T load(String token);


    /**
     * 移除token
     *
     * @param token token
     */
    void remove(String token);

}
