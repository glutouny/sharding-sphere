package com.yangl.shardingsphere.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author li.yang01@hand-china.com 2020/9/9 11:55 上午
 */
@Configuration
@MapperScan("com.yangl.shardingsphere.infra.mapper")
public class MybatisPlusConfiguration {


}
