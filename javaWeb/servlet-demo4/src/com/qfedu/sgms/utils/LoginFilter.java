package com.qfedu.sgms.utils;

import com.qfedu.sgms.dto.StudentDTO;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1,拦截所有用户请求
        //需要知道请求的路径
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
        //截取uri最后一个斜杠后的路径
        String requestPath = uri.substring(uri.lastIndexOf("/") + 1);

        //判断如果是非受限资源直接放行，如果是受限资源则需要验证登录
        if ("login.jsp".equals(requestPath) || "CheckServlet".equals(requestPath)){
            filterChain.doFilter(servletRequest, servletResponse);
        } else if ("".equals(requestPath)){
            response.sendRedirect("login.jsp");
        } else {
            //进入else表示请求是受限资源
            HttpSession session = request.getSession();
            StudentDTO student = (StudentDTO) session.getAttribute("stu");
            //判断session中是否有用户信息如果有放行，如果没有用户未登录
            if (student != null){
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                String tips = "请先登录!";
                request.setAttribute("tips", tips);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
