package com.example.lazy;

import com.example.lazy.service.FooService;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LazyApplication {
    private static final Logger log = LoggerFactory.getLogger(LazyApplication.class);

    private final FooService fooService;

    public LazyApplication(FooService fooService) {
        log.debug("Construct lazy application");
        this.fooService = fooService;
    }

    @PostConstruct
    public void post() {
        log.debug("Lazy application post construct");
        fooService.process();
    }


    public static void main(String[] args) {
        SpringApplication.run(LazyApplication.class, args);
    }

}
