package com.kunal.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author kunal
 */

@Slf4j
@SpringBootApplication
public class RouletteCasinoGameApplication {

    public static void main(String[] args) {
        SpringApplication.run(RouletteCasinoGameApplication.class, args);
        log.info("Started Spring Boot Application {} ");
    }

}
