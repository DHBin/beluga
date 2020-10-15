package cn.dhbin.beluga.generator;

import cn.dhbin.beluga.generator.data.SqlData;
import cn.dhbin.beluga.generator.strategy.SqlDataGenerateStrategy;
import cn.dhbin.beluga.generator.strategy.impl.SqlDataGenerateStrategyImpl;
import cn.dhbin.minion.core.generate.MinionVelocityTemplateEngine;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;

import java.util.Map;

/**
 * @author dhb
 */
public class BelugaVelocityTemplateEngine extends MinionVelocityTemplateEngine {

    @Override
    public Map<String, Object> getObjectMap(TableInfo tableInfo) {
        SqlDataGenerateStrategy sqlDataGenerateStrategy = new SqlDataGenerateStrategyImpl(getConfigBuilder(), tableInfo);
        SqlData sqlData = sqlDataGenerateStrategy.generate();
        Map<String, Object> objectMap = super.getObjectMap(tableInfo);
        objectMap.put("sqlData", sqlData);
        return objectMap;
    }
}
