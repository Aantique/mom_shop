package com.momshop.mom_shop;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@EnableScheduling
@EnableSwagger2
@MapperScan(basePackages = {"com.momshop.mom_shop.base.dao.mapper"})
public class MomShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(MomShopApplication.class, args);
    }

}
