package com.iyoungman.mop.api;

import java.util.TimeZone;
import javax.annotation.PostConstruct;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Application {

    private static final String APPLICATION_LOCATIONS = "spring.config.location="
            + "classpath:application.yml";

    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .bannerMode(Banner.Mode.OFF)
                .properties(APPLICATION_LOCATIONS)
                .build()
                .run(args);
    }

}
