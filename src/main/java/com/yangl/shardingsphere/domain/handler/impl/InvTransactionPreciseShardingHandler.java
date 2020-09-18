package com.yangl.shardingsphere.domain.handler.impl;

import com.yangl.shardingsphere.domain.handler.PreciseShardingHandler;
import com.yangl.shardingsphere.infra.constants.ShardingShpereConstants;
import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author li.yang01@hand-china.com 2020/9/17 3:28 下午
 */
@Service
public class InvTransactionPreciseShardingHandler  implements PreciseShardingHandler {

    @Override
    public String algorithmLogicTableName(Collection<String> availableTargetNames, PreciseShardingValue<String> shardingValue) {
        return null;
    }

    @Override
    public String LogicTableName() {
        return ShardingShpereConstants.LogicTableName.INV_TRANSACTION;
    }
}

