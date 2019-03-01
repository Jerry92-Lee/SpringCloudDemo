package com.imooc.security.config;/**
 * @author Jerry
 * @version 2019-02-28
 */

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/28 17:03
 * @Version 1.0
 **/
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
