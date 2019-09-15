package com.redsun.rpc.dubbo.web;


import com.redsun.rpc.dubbo.provider.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuguangrong
 * @description 管理类
 * @date Created at 17:28 2019/9/13
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Reference(version = "1.0.0",group = "glory", loadbalance = "glory")
    private DemoService demoService;

    @RequestMapping("/invoke")
    public String invoke(@RequestParam(name = "port") Integer port) {
        logger.info("invoke method be invoked!port = " + port);
        return demoService.sayHello(port);
    }

}
