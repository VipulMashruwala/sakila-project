package project.curd.sakila.service.Implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import project.curd.sakila.configuration.CustomConfiguration;
import project.curd.sakila.configuration.DatabaseConfiguration;
import project.curd.sakila.configuration.SecretManagerConfiguration;

@AllArgsConstructor
@Service
public class ConfigurationService {

    private final CustomConfiguration customConfiguration;
    private final SecretManagerConfiguration secretManagerConfiguration;
    private final DatabaseConfiguration databaseConfiguration;

    public String getConfigurationData(String key){
        customConfiguration.getConfiguration(key);
        return customConfiguration.getConfiguration(key);
    }

    public String getDatabaseConfiguration(){
        databaseConfiguration.fetchDatabaseConfiguration();
        return "Database configuration loaded";
    }

    public String getSecretManagerConfiguration(){
        secretManagerConfiguration.fetchSecretManagerConfiguration();
        return "Secret Manager configuration loaded";
    }
}
