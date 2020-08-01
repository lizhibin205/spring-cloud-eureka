package com.bytrees.cloud.eureka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication implements ApplicationListener<ApplicationEvent> {
    private static final Logger logger = LoggerFactory.getLogger(EurekaServerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        logger.info("EurekaServerApplication.onApplicationEvent: {}", event);
    }
}
