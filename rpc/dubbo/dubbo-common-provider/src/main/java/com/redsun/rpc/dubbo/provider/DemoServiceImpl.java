package com.redsun.rpc.dubbo.provider;

import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service(version = "1.0.0",group = "glory")
public class DemoServiceImpl implements DemoService {
    private static final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Override
    public String sayHello(Integer port) {
        logger.info("Hello " + port + " request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return "Hello ,"+port+" response from provider: " + RpcContext.getContext().getLocalAddress();
    }

}
