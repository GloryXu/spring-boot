package com.redsun.test.aaaa;

import com.redsun.test.circle.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

/**
 * @author qiquan
 * @date 2020/06/12 15:32
 */
@Service
//@DependsOn("b")
public class C {

    @Autowired
    private A a;
}
