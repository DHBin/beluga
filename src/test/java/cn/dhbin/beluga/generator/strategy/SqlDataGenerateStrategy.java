package cn.dhbin.beluga.generator.strategy;


import cn.dhbin.beluga.generator.data.SqlData;

/**
 * SqlData生成策略
 *
 * @author dhb
 */
public interface SqlDataGenerateStrategy {

    /**
     * 生成SqlData
     *
     * @return {@link SqlData}
     */
    SqlData generate();

}
