package com.li.cn;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ZkClient {

    public static void main(String[] args) throws Exception {

        CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.233.123:2181", new RetryOneTime(1000));
        client.start();
        client.blockUntilConnected();

        ServiceDiscovery<Object> serviceDiscovery = ServiceDiscoveryBuilder
                .builder(Object.class)
                .client(client)
                .basePath("/soa").build();

        Collection<ServiceInstance<Object>> list = serviceDiscovery.queryForInstances("prouct");

        //当存在多个服务时
        List<String> services = new ArrayList<>();

        list.forEach((instance) -> {
            services.add(instance.getAddress() + ":" + instance.getPort());
        });


        RestTemplate rest = new RestTemplate();
    }
}
