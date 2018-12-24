package com.power.demo;

import com.power.demo.config.ConfigBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.util.StopWatch;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Spring Boot 应用启动类
 * <p>
 * Created by JeffWong.
 */

// Spring Boot 应用的标识
@SpringBootApplication
// mapper 接口类扫描包配置
@MapperScan("com.power.demo.dao")
@EnableConfigurationProperties({ConfigBean.class})
@EnableSwagger2
public class Application {

    public static void main(String[] args) {

        StopWatch watch = new StopWatch();

        watch.start();

        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        SpringApplication.run(Application.class, args);

        watch.stop();

        System.out.println(String.format("总耗时：%s", watch.getTotalTimeMillis()));

    }
}
