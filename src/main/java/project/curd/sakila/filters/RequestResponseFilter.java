package project.curd.sakila.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
public class RequestResponseFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;

        String correlationId = httpRequest.getHeader("CorrelationId");

        if(correlationId == null){
            correlationId = UUID.randomUUID().toString();
        }

        httpResponse.setHeader("CorrelationId", correlationId);

        MDC.put("CorrelationId", correlationId);

        try {
            System.out.println("Running request response filter before controller....");
            chain.doFilter(request, response);
            System.out.println("Running request response filter after controller....");
        }
        finally {
            MDC.remove("CorrelationId");
        }
    }
}
