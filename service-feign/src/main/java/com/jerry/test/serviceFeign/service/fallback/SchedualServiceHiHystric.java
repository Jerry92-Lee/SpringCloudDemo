package com.jerry.test.serviceFeign.service.fallback;

import com.jerry.test.serviceFeign.service.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * @author Jerry
 * @version 2019-03-13
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClient(String name) {
        return "Sorry "+name+", service-feign is error !";
    }
}
