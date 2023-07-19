package com.qfedu.mtlms.filters;

import com.qfedu.mtlms.dto.Manager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Login filter.
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1.Gets the url of the requested resource.
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
        //Intercepts the string url path.
        String path = uri.substring(uri.lastIndexOf("/")+1);
        //Identify unconstrained resources.
        if ("login.jsp".equals(path) || "ManagerLoginServlet".equals(path) || "CheckCodeServlet".equals(path)
        || path.endsWith(".js") || path.endsWith(".css") || path.endsWith(".jpg") || path.endsWith(".png") || path.endsWith(".bmp")){
            filterChain.doFilter(servletRequest, servletResponse);
        } else{
            //Judgment constrained resources.
            HttpSession session = request.getSession();
            Manager manager = (Manager) session.getAttribute("mgr");
            if (manager == null){
                if ("".equals(path)){
                    response.sendRedirect("login.jsp");
                } else{
                    //The login page prompts you to log in.
                    request.setAttribute("type", "info");
                    request.setAttribute("tips", "请先登录！");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            } else{
                //If you have logged in, the system permits.
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
