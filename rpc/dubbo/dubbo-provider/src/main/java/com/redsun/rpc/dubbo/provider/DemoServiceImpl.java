package com.redsun.rpc.dubbo.provider;

import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoServiceImpl implements DemoService {
    private static final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Override
    public String sayHello(Integer sleepTime) {
        logger.info("sleep time is " + sleepTime + ", Hello request from consumer: " + RpcContext.getContext().getRemoteAddress());
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            logger.error("interrupt exception ", e);
        }
        return "Hello response from provider: " + RpcContext.getContext().getLocalAddress();
    }

}
