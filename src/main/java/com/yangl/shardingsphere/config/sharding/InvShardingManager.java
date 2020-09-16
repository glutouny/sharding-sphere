package com.yangl.shardingsphere.config.sharding;

import io.shardingsphere.shardingjdbc.spring.boot.common.SpringBootConfigMapConfigurationProperties;
import io.shardingsphere.shardingjdbc.spring.boot.common.SpringBootPropertiesConfigurationProperties;
import io.shardingsphere.shardingjdbc.spring.boot.masterslave.SpringBootMasterSlaveRuleConfigurationProperties;
import io.shardingsphere.shardingjdbc.spring.boot.sharding.SpringBootShardingRuleConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author li.yang01@hand-china.com 2020/9/16 11:55 上午
 */
@EnableConfigurationProperties({
        SpringBootShardingRuleConfigurationProperties.class, SpringBootMasterSlaveRuleConfigurationProperties.class,
        SpringBootConfigMapConfigurationProperties.class, SpringBootPropertiesConfigurationProperties.class
})
public class InvShardingManager {
}
