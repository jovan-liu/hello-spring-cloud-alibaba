package io.jovan.liu.hello.spring.cloud.alibaba.nacos.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderApplication {
    @Value("${server.port}")
    private String port;

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(NacosProviderApplication.class, args);
    }

    @RestController
    public class EchoController {

        @GetMapping("/echo/{message}")
        public String echo(@PathVariable("message") String message) {
            String name = applicationContext.getEnvironment().getProperty("user.name");
            return "Hello Nacos Provider: " + message + " i am from port " + port + " name: " + name;
        }

        @GetMapping("/hi")
        public String hi() {
            String name = applicationContext.getEnvironment().getProperty("user.name");
            return name;
        }
    }

}
