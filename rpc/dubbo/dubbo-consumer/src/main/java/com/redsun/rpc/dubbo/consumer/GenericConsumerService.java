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
    private static Map<String, ReferenceConfig> referenceConfigMap = new HashMap<>();

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
            consumerConfig.setGroup("glory");
            consumerConfig.setVersion("1.0.0");
            reference.setConsumer(consumerConfig);

            genericService = reference.get();
            genericServiceMap.put(mapKey, genericService);
            referenceConfigMap.put(mapKey, reference);
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
        consumerConfig.setGroup("glory");
        consumerConfig.setVersion("1.0.0");
        reference.setConsumer(consumerConfig);

        genericServiceMap.put("aaa", reference.get());
        referenceConfigMap.put("aaa", reference);
    }


    public void shutdown() {
        ReferenceConfig referenceConfig = referenceConfigMap.get("aaa");
        referenceConfig.destroy();

        referenceConfigMap.remove("aaa");
        genericServiceMap.remove("aaa");

    }

    /**
     * destroy referenceConfig
     * 测试 genericService能否调用
     *
     * 如下异常：
     * org.apache.dubbo.rpc.RpcException: Rpc cluster invoker for interface org.apache.dubbo.rpc.service.GenericService on consumer 192.168.199.231 use dubbo version 2.7.2 is now destroyed! Can not invoke any more.
     */
    public void shutDownAndRemove() {
        ReferenceConfig referenceConfig = referenceConfigMap.get("aaa");
        referenceConfig.destroy();

        referenceConfigMap.remove("aaa");
        genericServiceMap.remove("aaa");
    }
}
