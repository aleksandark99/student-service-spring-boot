package com.ftn.studentservice.security;



import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

@Component
public class CorsSetup implements Filter {
    public static final String PAGE = "Page";
    public static final String ELEMENTS = "Elements";
    public static final String PAGE_SIZE = "Page-Size";
    public static final String TOTAL_PAGES = "Total-Pages";
    public static final String TOTAL_ELEMENTS = "Total-Elements";
    public CorsSetup() {}

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Page, Elements, Page-Size, Total-Elements, TotalPages, Access-Control-Allow-Headers, Access-Control-Allow-Origin, mode, Origin, Content-Type, Accept, X-Requested-With, remember-me, Authorization, language");
        response.setHeader("Access-Control-Expose-Headers","Page, Elements, Page-Size, Total-Elements, TotalPages, Access-Control-Allow-Headers, Access-Control-Allow-Origin, mode, Origin, Content-Type, Accept, X-Requested-With, remember-me, Authorization, language");

        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

}