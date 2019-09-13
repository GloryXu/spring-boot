package com.redsun.rpc.dubbo.web;


import com.redsun.rpc.dubbo.consumer.GenericConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private GenericConsumerService genericConsumerService;

    @RequestMapping("/timeout")
    public String changeRpcTimeout(@RequestParam(name = "timeout") Integer timeout) {
        logger.info("changeRpcTimeout be invoked!timeout = " + timeout);

        genericConsumerService.changeTimeout(timeout);
        return "change success!";
    }

    @RequestMapping("/invoke")
    public String invokeProvider(@RequestParam(name = "timeout") Integer timeout) {
        logger.info("invokeProvider be invoked!timeout = " + timeout);
        genericConsumerService.invoke(timeout);
        return "invoke success!";
    }

}
