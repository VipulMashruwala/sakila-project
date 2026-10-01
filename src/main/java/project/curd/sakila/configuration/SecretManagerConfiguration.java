package project.curd.sakila.configuration;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class SecretManagerConfiguration {

    public SecretManagerConfiguration(){
        System.out.println("Secret config constructor set");
    }

    @PostConstruct
    public void loadConfigurationFromSecretManager(){
        System.out.println("Loading config from secret....");
    }

    @PreDestroy
    public void destroyConfiguration(){
        System.out.println("Destroy secret config...");
    }

    public void fetchSecretManagerConfiguration(){
        System.out.println("Loading secret into service class...");
    }
}
