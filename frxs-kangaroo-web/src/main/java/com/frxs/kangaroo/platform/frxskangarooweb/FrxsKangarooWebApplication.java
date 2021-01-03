package com.frxs.kangaroo.platform.frxskangarooweb;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@MapperScan({"com.frxs.kangaroo.platform.frxskangaroodal.mapper"})
@EnableWebMvc
@EnableAspectJAutoProxy(proxyTargetClass = true)
@SpringBootApplication(scanBasePackages = {"com.frxs"})
public class FrxsKangarooWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrxsKangarooWebApplication.class, args);
    }

}
