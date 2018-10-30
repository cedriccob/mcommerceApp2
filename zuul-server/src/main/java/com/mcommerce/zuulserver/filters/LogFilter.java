package com.mcommerce.zuulserver.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LogFilter extends ZuulFilter {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public String filterType() {
        //return "pre";
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
      //  return true;
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        /*HttpServletRequest req = RequestContext.getCurrentContext().getRequest();

        log.info("***** Requête interceptée ! L'URL est : {} ", req.getRequestURL());
        return null;*/

        HttpServletResponse response = RequestContext.getCurrentContext().getResponse();
       // response.setStatus(400);
        log.info("Code HTTP {}", response.getStatus());

        return null;
    }
}
