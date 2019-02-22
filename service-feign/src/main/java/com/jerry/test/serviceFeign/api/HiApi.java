package com.jerry.test.serviceFeign.api;/**
 * @author Jerry
 * @version 2019-02-22
 */

import com.jerry.test.serviceFeign.service.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/22 13:56
 * @Version 1.0
 **/
@RestController
public class HiApi {

    @Autowired
    SchedualServiceHi schedualServiceHi;

    @GetMapping(value = "/hi")
    public String sayHi(String name){
        return schedualServiceHi.sayHiFromClient(name);
    }
}
