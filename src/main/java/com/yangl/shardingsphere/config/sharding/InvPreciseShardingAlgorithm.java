package com.yangl.shardingsphere.config.sharding;

import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;

/**
 * @author li.yang01@hand-china.com 2020/9/16 10:46 上午
 */
@Slf4j
public class InvPreciseShardingAlgorithm implements PreciseShardingAlgorithm<String> {

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> shardingValue) {
        for (String name : availableTargetNames) {
            if (name.endsWith(String.valueOf(shardingValue.getValue()))) {
                log.info("return name: " + name);
                return name;
            }
        }
        return null;
    }
}

