package com.sxk.wxpusher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class WxpusherApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxpusherApplication.class, args);
    }

}
