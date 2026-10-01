package project.curd.sakila.configuration;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.web.context.annotation.RequestScope;

public class DatabaseConfiguration {

    public DatabaseConfiguration(){
        System.out.println("Database config constructor set");
    }

    @PostConstruct
    public void loadConfigurationFromDatabase(){
        System.out.println("Loading config from database....");
    }

    @PreDestroy
    public void destroyConfiguration(){
        System.out.println("Destroy database config...");
    }

    public void fetchDatabaseConfiguration(){
        System.out.println("Loading configuration into service class");
    }
}
