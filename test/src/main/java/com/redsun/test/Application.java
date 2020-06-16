package com.redsun.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author xuguangrong
 * @description
 * @date Created at 22:11 2019/9/13
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.redsun.test"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}