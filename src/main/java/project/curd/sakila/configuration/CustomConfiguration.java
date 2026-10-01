package project.curd.sakila.configuration;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.HashMap;
import java.util.Map;

//@RequestScope
//@Scope("prototype")
@Component
public class CustomConfiguration {

    Map<String, String> configuration;

    public CustomConfiguration(){
        System.out.println("Custom Configuration Constructor set");

        this.configuration = new HashMap<>();
    }

    @PostConstruct
    public void loadConfigurations(){
        System.out.println("Loading Custom Configuration......");

        configuration.put("Service-url", "https://www.google.com");
        configuration.put("Service-timeout", "30");
    }

    @PreDestroy
    public void destroyConfiguration(){
        System.out.println("Destroying Custom Configuration......");
    }

    public String getConfiguration(String key){
        return configuration.get(key);
    }
}
