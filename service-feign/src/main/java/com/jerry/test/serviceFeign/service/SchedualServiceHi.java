package com.jerry.test.serviceFeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Jerry
 * @version 2019-02-22
 */
@FeignClient(value = "service-hi")
public interface SchedualServiceHi {

    @GetMapping(value = "/hi")
    String sayHiFromClient(String name);
}
