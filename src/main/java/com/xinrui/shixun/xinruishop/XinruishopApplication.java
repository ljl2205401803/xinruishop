package com.xinrui.shixun.xinruishop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.xinrui.shixun.xinruishop.mapper")
//开启事务
@EnableTransactionManagement
public class XinruishopApplication {

    public static void main(String[] args) {
        SpringApplication.run(XinruishopApplication.class, args);
    }

}
