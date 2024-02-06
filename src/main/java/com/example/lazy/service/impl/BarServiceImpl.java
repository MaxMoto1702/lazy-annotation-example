package com.example.lazy.service.impl;

import com.example.lazy.service.BarService;
import com.example.lazy.service.FooService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class BarServiceImpl implements BarService {
    private static final Logger log = LoggerFactory.getLogger(BarServiceImpl.class);

    private final FooService fooService;

    public BarServiceImpl(@Lazy FooService fooService) {
        log.debug("Construct bar service");
        this.fooService = fooService;
    }

    @Override
    public void process() {
        log.debug("Bar process");
    }
}
