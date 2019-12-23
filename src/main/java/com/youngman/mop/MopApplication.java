package com.youngman.mop;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class MopApplication {

    public static final String APPLICATION_LOCATIONS = "spring.config.location="
            + "classpath:dw.yml,"
            + "classpath:aws.yml";

    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(MopApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .properties(APPLICATION_LOCATIONS)
                .build()
                .run(args);
    }
}
