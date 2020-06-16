package com.redsun.test.circle;

import com.redsun.test.circle.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qiquan
 * @date 2020/06/12 14:58
 */
@Service
public class B {

    @Autowired
    private A a;

}
