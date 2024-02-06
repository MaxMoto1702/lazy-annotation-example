package com.example.lazy.service.impl;

import com.example.lazy.service.BarService;
import com.example.lazy.service.FooService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FooServiceImpl implements FooService {
    private static final Logger log = LoggerFactory.getLogger(FooServiceImpl.class);

    private final BarService barService;

    public FooServiceImpl(BarService barService) {
        log.debug("Construct foo service");
        this.barService = barService;
    }

    @Override
    public void process() {
        log.debug("Foo process");
        barService.process();
    }
}
