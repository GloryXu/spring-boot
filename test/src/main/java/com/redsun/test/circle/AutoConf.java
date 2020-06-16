package com.redsun.test.circle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qiquan
 * @date 2020/06/16 10:02
 */
@Configuration
public class AutoConf {

    @Bean
    public A a(B b) {
        A a = new A();
        a.setB(b);
        return a;
    }

}
