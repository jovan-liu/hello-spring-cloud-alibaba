package io.jovan.liu.hello.spring.cloud.alibaba.nacos.consumer.feign.service.fallback;

import io.jovan.liu.hello.spring.cloud.alibaba.nacos.consumer.feign.service.EchoService;
import org.springframework.stereotype.Component;

@Component
public class EchoServiceFallback implements EchoService {
    @Override
    public String echo(String message) {
        return "echo fallback";
    }
}
