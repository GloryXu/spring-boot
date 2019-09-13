package com.redsun.rpc.dubbo.provider;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author xuguangrong
 * @description dubbo泛化 provider，验证接口调用的超时时间
 * @date Created at 18:19 2019/7/14
 */
@Service
public class GenericProviderService {

    @PostConstruct
    public void providerService() {
        ServiceConfig<DemoServiceImpl> service = new ServiceConfig<>();
        service.setApplication(new ApplicationConfig("dubbo-demo-generic-provider"));
        service.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
        service.setInterface(DemoService.class);
        service.setRef(new DemoServiceImpl());
        service.setGeneric("true");
        service.export();
    }
}
