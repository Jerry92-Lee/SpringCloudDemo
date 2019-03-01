package com.imooc.security.controller;/**
 * @author Jerry
 * @version 2019-02-28
 */

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/28 16:09
 * @Version 1.0
 **/
@RestController
public class SecurityController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/common")
    public String commonAccess() {
        return "only login can view ...";
    }

    @RequestMapping("/admin")
    @PreAuthorize("hasRole(' ')")
    public String admin() {
        return "only admin can access ...";
    }
}
