package com.yangl.shardingsphere.domain.handler;

import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;

import java.util.Collection;

/**
 * @author li.yang01@hand-china.com 2020/9/17 3:12 下午
 */
public interface PreciseShardingHandler {


    /**
     * 获取实际处理逻辑表名
     * @return
     */
    String algorithmLogicTableName(Collection<String> availableTargetNames, PreciseShardingValue<String> shardingValue);

    /**
     * 逻辑表名称
     *
     * @return 队列名称
     */
    String LogicTableName();
}
