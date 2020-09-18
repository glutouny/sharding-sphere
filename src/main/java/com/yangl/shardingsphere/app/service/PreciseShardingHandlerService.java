package com.yangl.shardingsphere.app.service;

import com.yangl.shardingsphere.domain.handler.PreciseShardingHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author li.yang01@hand-china.com 2020/9/17 5:47 下午
 */
@Slf4j
@Component
public class PreciseShardingHandlerService {

    private Map<String, PreciseShardingHandler> preciseShardingHandlers;

    public PreciseShardingHandlerService(List<PreciseShardingHandler> handlers) {
        this.preciseShardingHandlers = new HashMap<>(handlers.size());
        for (PreciseShardingHandler handler : handlers) {
            log.info("LogicTableName:{}",handler.LogicTableName());
            this.preciseShardingHandlers.put(handler.LogicTableName(), handler);
        }
    }
    
   public PreciseShardingHandler getPreciseShardingHandler(String logicTableName) {
        return preciseShardingHandlers.get(logicTableName);
   }
    
}
