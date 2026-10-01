package project.curd.sakila.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class ApplicationConfiguration {

    @Bean
    @RequestScope
    public DatabaseConfiguration fetchDatabaseConfiguration(){
        System.out.println("Fetching database config....");
        return new DatabaseConfiguration();
    }

    @Bean
    public SecretManagerConfiguration fetchSecretManagerConfiguration(){
        System.out.println("Fetching secret manager config....");
        return new SecretManagerConfiguration();
    }
}
