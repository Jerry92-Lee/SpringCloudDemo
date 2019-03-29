package com.jerry.hello.controller;

import com.jerry.hello.annotation.API;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Jerry
 * @version 2019-03-28
 */
@API(apiType = "/frontapi",apiPath = "/v1")
public class TestController {

    @RequestMapping(value = "aa")
    public String test() {
        return "this is test()";
    }
}
