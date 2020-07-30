package com.iyoungman.mop.api.common.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Created by iyoungman on 2020-06-18.
 */

@Slf4j
@Component
public class ProfileRunner implements ApplicationRunner {

    @Autowired
    private ApplicationContext applicationContext;

    @Value("${spring.profiles.include}")
    private String include;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Environment environment = applicationContext.getEnvironment();
        log.info("Profile : {}", environment.getActiveProfiles());
        log.info("Include : {}", include);
    }
}
