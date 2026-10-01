package project.curd.sakila.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import project.curd.sakila.model.ActorResponse;
import project.curd.sakila.model.BaseHttpResponseModel;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

@AllArgsConstructor
@Component
public class CachingActorInterceptor implements HandlerInterceptor {

    private final ObjectMapper objectMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        System.out.println("Interceptor Before controller");
        System.out.println("Checking response in cache...");

        Map<String, String> pathVariables = (Map<String, String>)request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

        Integer actorId = Integer.valueOf(pathVariables.get("actorId"));

        if(actorId == 203){

            System.out.println("Response found in cache...");
            BaseHttpResponseModel baseHttpResponse = new BaseHttpResponseModel();

            baseHttpResponse.setStatus("Success");
            baseHttpResponse.setMessage("Record fetch successfully");

            ActorResponse actorResponse = new ActorResponse();
            actorResponse.setId(203);
            actorResponse.setFirstName("Tesla");
            actorResponse.setLastName("IT");
            baseHttpResponse.setResponse(actorResponse);

            String jsonResponse = objectMapper.writeValueAsString(baseHttpResponse);
            response.setContentType("application/json");
            response.getWriter().write(String.valueOf(jsonResponse));

            return false;
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        System.out.println("Interceptor after Request completed");
    }
}
