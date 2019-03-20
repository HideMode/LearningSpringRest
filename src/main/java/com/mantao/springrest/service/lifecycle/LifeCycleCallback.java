package com.mantao.springrest.service.lifecycle;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by Manito on 2019/3/11.
 */
@Service
@Log4j2
public class LifeCycleCallback {

    public LifeCycleCallback() {
        log.info("init");
    }

    @PostConstruct
    public void postConstruct() {
       this.log.info("post Construct");
    }


    @PreDestroy
    public void preDestory() {
        log.info("pre Destroy");
    }
}

