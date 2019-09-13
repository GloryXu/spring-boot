package com.redsun.rpc.dubbo.consumer;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ConsumerConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.service.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuguangrong
 * @description 泛化消费者执行类，验证超时时间
 * 依赖接口
 * @date Created at 21:59 2019/7/14
 */
@Service
public class GenericConsumerService {
    private static final Logger logger = LoggerFactory.getLogger(GenericConsumerService.class);

    private static Map<String, GenericService> genericServiceMap = new HashMap<>();

    public void invoke(Integer number) {
        GenericService service = getService("aaa");

        Object response = service.$invoke("sayHello", new String[]{Integer.class.getName()}, new Object[]{number});

        logger.info("response is " + response);
    }

    /**
     * get service
     * @param mapKey
     * @return
     */
    private GenericService getService(String mapKey) {
        GenericService genericService = genericServiceMap.get(mapKey);
        if (genericService == null) {
            logger.info("genericService is null!");
            ReferenceConfig<GenericService> reference = new ReferenceConfig<>();
            ApplicationConfig applicationConfig = new ApplicationConfig("dubbo-demo-generic-consumer");
            applicationConfig.setQosPort(22221);// 默认22222
            reference.setApplication(applicationConfig);
            reference.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
            reference.setInterface("com.redsun.rpc.dubbo.provider.DemoService");
            reference.setGeneric("true");
            reference.setLazy(false);
            reference.setTimeout(2000);

            ConsumerConfig consumerConfig = new ConsumerConfig();
            consumerConfig.setCorethreads(2);
//            consumerConfig.setTimeout(2000);
            reference.setConsumer(consumerConfig);

            genericService = reference.get();
            genericServiceMap.put("aaa", genericService);
        }

        return genericService;
    }

    /**
     * 改变超时时间
     * @param timeout
     */
    public void changeTimeout(Integer timeout) {
        ReferenceConfig<GenericService> reference = new ReferenceConfig<>();
        ApplicationConfig applicationConfig = new ApplicationConfig("dubbo-demo-generic-consumer");
        applicationConfig.setQosPort(22221);// 默认22222
        reference.setApplication(applicationConfig);
        reference.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
        reference.setInterface("com.redsun.rpc.dubbo.provider.DemoService");
        reference.setGeneric("true");
        reference.setLazy(false);
        reference.setTimeout(timeout);

        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setCorethreads(2);
//        consumerConfig.setTimeout(timeout);
        reference.setConsumer(consumerConfig);

        genericServiceMap.put("aaa", reference.get());
    }
}
