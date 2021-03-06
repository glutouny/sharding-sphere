package com.yangl.shardingsphere.config.sharding;

import com.yangl.shardingsphere.infra.constants.ShardingShpereConstants;
import com.yangl.shardingsphere.infra.hash.KetamaHash;
import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import lombok.extern.slf4j.Slf4j;


import java.util.ArrayList;
import java.util.Collection;


/**
 * @author li.yang01@hand-china.com 2020/9/16 10:46 上午
 */
@Slf4j
public class InvPreciseShardingAlgorithm implements PreciseShardingAlgorithm<String> {

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> shardingValue) {
        KetamaHash  ketamaHash = new KetamaHash(new ArrayList<>(availableTargetNames));
        log.info("availableTargetNames:{},shardingValue:{}",availableTargetNames,shardingValue);
        String actualNode = null;
        try {
            actualNode = ketamaHash.getActualNode(shardingValue.getValue());
        } catch (Exception e) {
            e.printStackTrace();
            log.info("hhahhahha");
        }
        log.info("actaulNode:{}",actualNode);
        return ketamaHash.getActualNode(shardingValue.getValue());
    }
}

