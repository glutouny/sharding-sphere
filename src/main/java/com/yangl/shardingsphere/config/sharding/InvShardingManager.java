package com.yangl.shardingsphere.config.sharding;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.yangl.shardingsphere.infra.hash.KetamaHash;
import io.shardingsphere.api.algorithm.sharding.ShardingValue;
import io.shardingsphere.core.hint.HintManagerHolder;
import io.shardingsphere.core.routing.strategy.hint.HintShardingStrategy;
import io.shardingsphere.core.util.InlineExpressionParser;
import io.shardingsphere.core.yaml.sharding.YamlTableRuleConfiguration;
import io.shardingsphere.shardingjdbc.spring.boot.common.SpringBootConfigMapConfigurationProperties;
import io.shardingsphere.shardingjdbc.spring.boot.common.SpringBootPropertiesConfigurationProperties;
import io.shardingsphere.shardingjdbc.spring.boot.masterslave.SpringBootMasterSlaveRuleConfigurationProperties;
import io.shardingsphere.shardingjdbc.spring.boot.sharding.SpringBootShardingRuleConfigurationProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author li.yang01@hand-china.com 2020/9/16 11:55 上午
 */
@Slf4j
@Component
@EnableConfigurationProperties({
        SpringBootShardingRuleConfigurationProperties.class, SpringBootMasterSlaveRuleConfigurationProperties.class,
        SpringBootConfigMapConfigurationProperties.class, SpringBootPropertiesConfigurationProperties.class
})

@RequiredArgsConstructor
public class InvShardingManager {

    private final SpringBootShardingRuleConfigurationProperties shardingProperties;

    private static final Map<String, KetamaHash> ketamaHashMap = new ConcurrentHashMap<>();


    @PostConstruct
    public void initKetamaHash() {
        Map<String, YamlTableRuleConfiguration> tables = shardingProperties.getTables();
        Map<String,KetamaHash> ketamaHashMap = new HashMap<>();
        tables.entrySet().forEach(table -> {
            log.info("table:"+table.getKey()+"value:"+table.getValue().getActualDataNodes());
            List<String> dataNodes = new InlineExpressionParser(table.getValue().getActualDataNodes()).splitAndEvaluate();
            List<String> actualNodes = new ArrayList<>(dataNodes.size());
            for (String dataNode : dataNodes) {
                dataNode = dataNode.substring(dataNode.indexOf(".")+1);
                actualNodes.add(dataNode);
            }
            KetamaHash ketamaHash = new KetamaHash(actualNodes);
            ketamaHashMap.put(table.getKey(),ketamaHash);
        });
    }

    public Map<String, KetamaHash> getKetamaHashMap() {
        return ketamaHashMap;
    }
}
