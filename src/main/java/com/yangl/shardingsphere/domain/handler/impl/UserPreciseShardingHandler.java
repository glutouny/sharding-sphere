package com.yangl.shardingsphere.domain.handler.impl;

import com.yangl.shardingsphere.config.sharding.InvShardingManager;
import com.yangl.shardingsphere.domain.handler.PreciseShardingHandler;
import com.yangl.shardingsphere.infra.constants.ShardingShpereConstants;
import com.yangl.shardingsphere.infra.hash.KetamaHash;
import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

/**
 * @author li.yang01@hand-china.com 2020/9/17 3:14 下午
 */
@Slf4j
@Service
public class UserPreciseShardingHandler implements PreciseShardingHandler {

    @Autowired
    private InvShardingManager invShardingManager;

    @Override
    public String algorithmLogicTableName(Collection<String> availableTargetNames, PreciseShardingValue<String> shardingValue) {
        Map<String, KetamaHash> ketamaHashMap = invShardingManager.getKetamaHashMap();
        KetamaHash ketamaHash = ketamaHashMap.get(shardingValue.getLogicTableName());
        String actualNode = ketamaHash.getActualNode(shardingValue.getValue());
        log.info("actualNode:{}",actualNode);
        for (String availableTargetName : availableTargetNames) {
            if (availableTargetName.endsWith(String.valueOf(Long.parseLong(shardingValue.getValue()) % 3))) {
                return availableTargetName;
            }
        }
        return null;
    }

    @Override
    public String LogicTableName() {
        return ShardingShpereConstants.LogicTableName.TAB_USER;
    }
}
