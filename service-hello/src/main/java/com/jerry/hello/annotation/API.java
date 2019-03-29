package com.jerry.hello.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

/**
 * @author Jerry
 * @version 2019-03-28
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RestController
@RequestMapping
public @interface API {

    String apiType();

    @AliasFor(annotation = RequestMapping.class, attribute = "path")
    String apiPath();

}
