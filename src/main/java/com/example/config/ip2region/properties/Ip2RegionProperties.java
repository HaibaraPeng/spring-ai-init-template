package com.example.config.ip2region.properties;


import com.example.config.ip2region.properties.enums.LoadType;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Peng
 * @date 2025-09-24 23:20
 */
@Data
@ConfigurationProperties(prefix = "ip2region")
public class Ip2RegionProperties {

    /**
     * 加载数据方式，默认为内存加载
     */
    private LoadType loadType = LoadType.MEMORY;

}
