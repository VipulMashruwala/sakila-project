package project.curd.sakila.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.curd.sakila.service.Implementation.ConfigurationService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/sakila/config")
public class ConfigurationController {

    private final ConfigurationService configurationService;

    @GetMapping("/fetch/{configKey}")
    public String getConfiguration(@PathVariable String configKey){
        return configurationService.getConfigurationData(configKey);
    }

    @GetMapping("/fetch/database-config")
    public String getDatabaseConfiguration(){
        return configurationService.getDatabaseConfiguration();
    }

    @GetMapping("fetch/secret-config")
    public String getSecretManagerConfiguration(){
        return configurationService.getSecretManagerConfiguration();
    }

}
