package com.car.authentication;

import java.io.IOException;
 
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
@WebFilter(
		urlPatterns = {"/view/AdminHome.jsp","/view/create_car.jsp"}
		)
public class AuthenticationFilter implements Filter {
 
    private ServletContext context;
     
    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }
     
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
 
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        PrintWriter out=response.getWriter();
		
        String uri = req.getRequestURI();
        this.context.log("Requested Resource::"+uri);
        
        System.out.print(uri);
         
        HttpSession session = req.getSession(false);
         
        if(session.getAttribute("userId") == null){
            
            res.sendRedirect("admin.jsp");
        }
        else{
            // pass the request along the filter chain
            chain.doFilter(request, response);
        }
         
         
    }
    public void destroy() {
        //close any resources here
    }
   
}