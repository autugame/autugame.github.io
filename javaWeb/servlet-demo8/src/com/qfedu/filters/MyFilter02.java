package com.qfedu.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/FirstServlet")
public class MyFilter02 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter02");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("after MyFilter02");
    }

    @Override
    public void destroy() {

    }
}
