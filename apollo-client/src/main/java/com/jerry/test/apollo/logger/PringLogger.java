package com.jerry.test.apollo.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Jerry
 * @version 2019-03-18
 */
@Component
public class PringLogger {

    private static final Logger LOG = LoggerFactory.getLogger(PringLogger.class);

    @PostConstruct
    public void print(){
        Executors.newSingleThreadExecutor().submit(() -> {
            while (true){
                LOG.info("-----------------------------");
                LOG.info("我是info级别日志");
                LOG.error("我是error级别日志");
                LOG.warn("我是warn级别日志");
                LOG.debug("我是debug级别日志");
                TimeUnit.SECONDS.sleep(1);
            }
        });
    }
}
