package com.example;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Peng
 * @date 2025-09-24 21:52
 */
@SpringBootApplication(scanBasePackages = {"com.example.**"})
@MapperScan(basePackages = {"com.example.mapper","com.example.config.ai.spring.vector.mapper"})
//@EsMapperScan(value = "top.sharehome.springbootinittemplate.elasticsearch.mapper")
//@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
//@EnableConfigurationProperties
//@ConfigurationPropertiesScan(basePackages = {"top.sharehome.springbootinittemplate.config.**"})
@EnableTransactionManagement
//@ServletComponentScan(basePackages = {"top.sharehome.springbootinittemplate.config.**"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
