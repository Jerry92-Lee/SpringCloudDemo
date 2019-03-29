package com.jerry.test.serviceZuul.filter;/**
 * @author Jerry
 * @version 2019-02-22
 */

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2019/2/22 14:07
 * @Version 1.0
 **/
@Component
public class HiFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(HiFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        // filter执行顺序，数字越大优先级越低
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info("{} --> {}", request.getMethod(), request.getRequestURL());

        Object token = request.getParameter("tk");

        if(token == null){
            log.warn(" Token is null ...");

            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
