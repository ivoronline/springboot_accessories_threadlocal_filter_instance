package com.ivoronline.springboot_accessories_threadlocal_filter_instance.filter;

import com.ivoronline.springboot_accessories_threadlocal_filter_instance.context.UserContext;
import jakarta.servlet.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class MyFilter implements Filter {

  //PROPERTIES
  @Autowired UserContext userContext;

  //=========================================================================================================
  // DO FILTER
  //=========================================================================================================
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    try {
      String user = request.getParameter("user");
      userContext.setUser(user);
      chain.doFilter(request, response);
    } finally {
      userContext.clear();
      System.out.println("userContext.clear()");
    }
  }
  
  @Override
  public void init(FilterConfig filterConfig) throws ServletException { }
  
  @Override
  public void destroy() { }
  
}