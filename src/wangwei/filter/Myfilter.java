package wangwei.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Myfilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        HttpSession session=request.getSession();
        if (session.getAttribute("Name")==null){
            System.out.println("拦截");
            response.sendRedirect(request.getContextPath()+"/ems1.0-绿色版/login.jsp");
        }else {
            //放行
            filterChain.doFilter(servletRequest, servletResponse);
            System.out.println("响应回来");
        }
    }

    @Override
    public void destroy() {

    }
}
