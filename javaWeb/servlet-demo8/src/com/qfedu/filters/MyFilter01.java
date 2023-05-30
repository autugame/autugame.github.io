package com.qfedu.filters;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/FirstServlet")
public class MyFilter01 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("before");
        //放行，允许继续执行浏览器请求的目标资源
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("after");
    }

    @Override
    public void destroy() {

    }
}
