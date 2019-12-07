package com.wjf.system_wjf.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;



@WebFilter(filterName = "test", urlPatterns = "/*")
public class UrlFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("----------------------->过滤器被创建");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String requestURI = req.getRequestURI();
        System.out.println("--------------------->过滤器：请求地址"+requestURI);
        if(!requestURI.contains("/login")){
            System.out.println("请登录");
            filterChain.doFilter(servletRequest, servletResponse);
            //servletRequest.getRequestDispatcher("/failed/failed").forward(servletRequest, servletResponse);
        }else{
            System.out.println("放行");
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

        System.out.println("----------------------->过滤器被销毁");
    }
}
