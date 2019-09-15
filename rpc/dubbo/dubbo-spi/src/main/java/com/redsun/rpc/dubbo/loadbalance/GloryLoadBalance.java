package com.redsun.rpc.dubbo.loadbalance;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.RpcException;
import org.apache.dubbo.rpc.cluster.LoadBalance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author xuguangrong
 * @description 自定义负载均衡策略，旨在验证SPI
 * @date Created at 14:18 2019/9/15
 */
public class GloryLoadBalance implements LoadBalance {

    private static final Logger logger = LoggerFactory.getLogger(GloryLoadBalance.class);

    @Override
    public <T> Invoker<T> select(List<Invoker<T>> invokers, URL url, Invocation invocation) throws RpcException {
        Integer port = (Integer) invocation.getArguments()[0];// 前端传入的参数
        logger.info("前端传入端口为:" + port);
        for (Invoker invoker : invokers) {
            if (invoker.getUrl().getPort() == port) {
                return invoker;
            }
        }
        return invokers.get(0);
    }
}
