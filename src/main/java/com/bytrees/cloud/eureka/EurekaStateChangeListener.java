package com.bytrees.cloud.eureka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EurekaStateChangeListener {
    private static final Logger logger = LoggerFactory.getLogger(EurekaStateChangeListener.class);

    @EventListener
    public void listen(EurekaInstanceCanceledEvent event) {
        logger.warn("service offline: serverId: {}, appName: {}.", event.getServerId(), event.getAppName());
    }

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        logger.warn("service register: appName: {}.", event.getInstanceInfo().getAppName());
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        logger.warn("service renew: serverId: {}, appName: {}.", event.getServerId(), event.getAppName());
    }
    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        logger.warn("eureka registry start.");
    }

    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        logger.warn("eureka server start.");
    }
}
