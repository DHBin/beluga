package cn.dhbin.beluga.generator.strategy.impl;

import cn.dhbin.beluga.generator.data.SqlData;
import cn.dhbin.beluga.generator.strategy.SqlDataGenerateStrategy;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;

/**
 * @author dhb
 */
public class SqlDataGenerateStrategyImpl implements SqlDataGenerateStrategy {

    private final ConfigBuilder config;
    private final TableInfo tableInfo;
    private final StringBuffer baseUrlBuff = new StringBuffer();

    public SqlDataGenerateStrategyImpl(final ConfigBuilder configBuilder, final TableInfo tableInfo) {
        this.config = configBuilder;
        this.tableInfo = tableInfo;
        init();
    }

    private void init() {
        String moduleName = config.getPackageInfo().get("ModuleName");
        if (moduleName != null) {
            baseUrlBuff.append("/").append(moduleName);
        }
        baseUrlBuff.append("/");
        if (config.getStrategyConfig().isControllerMappingHyphenStyle()) {
            baseUrlBuff.append(StringUtils.camelToHyphen(tableInfo.getEntityPath()));
        } else {
            baseUrlBuff.append(tableInfo.getEntityPath());
        }
    }

    @Override
    public SqlData generate() {
        SqlData sqlData = new SqlData();
        String baseUrl = baseUrlBuff.toString();
        String idPath = "/{id:\\\\d+}";
        String baseUrlWithIdPath = baseUrl + idPath;
        String comment = tableInfo.getComment();

        sqlData.setListPermId(SecureUtil.md5(comment + "GET" + baseUrl));
        sqlData.setCreatePermId(SecureUtil.md5(comment + "POST" + baseUrl));
        sqlData.setDeletePermId(SecureUtil.md5(comment + "DELETE" + baseUrlWithIdPath));
        sqlData.setUpdatePermId(SecureUtil.md5(comment + "PUT" + baseUrl));
        sqlData.setRetrievePermId(SecureUtil.md5(comment + "GET" + baseUrlWithIdPath));
        return sqlData;
    }

}
