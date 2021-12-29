package web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
@ComponentScan("web")
public class ReestConfig {
    @Bean
    public RestTemplate getRestTmplate(){
        return new RestTemplate();
    }
}
