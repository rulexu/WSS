package com.rulexu.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class AppRunner implements ApplicationRunner {
    private final static Logger logger = LoggerFactory.getLogger(AppRunner.class);


    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        logger.info("程序启动执行........");
    }

}
