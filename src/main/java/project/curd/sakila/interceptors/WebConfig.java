package project.curd.sakila.interceptors;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@AllArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final CachingActorInterceptor cachingActorInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(cachingActorInterceptor)
                .addPathPatterns("/api/sakila/show-actor/{actorId}");
    }
}
