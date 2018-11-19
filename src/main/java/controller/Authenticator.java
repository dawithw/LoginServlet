package controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.xml.ws.WebEndpoint;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

@WebFilter(
            filterName = "myFilter",
            urlPatterns = {"/welcome.jsp"}
          )
public class Authenticator implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        try {
            HttpServletRequest req = (HttpServletRequest)request;
            if(req.getSession().getAttribute("user") == null) {
                req.getRequestDispatcher("/login").forward(req,response);
            } else {
                chain.doFilter(request,response);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void destroy() {

    }
}
