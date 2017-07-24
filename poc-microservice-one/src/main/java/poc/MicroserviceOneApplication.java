package poc;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableDiscoveryClient
@EnableResourceServer
public class MicroserviceOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceOneApplication.class, args);
    }

    @Configuration
    @EnableFeignClients
    class FeignClientsConfiguration {

        @Bean
        public RequestInterceptor oauth2FeignRequestInterceptor(OAuth2ClientContext oauth2ClientContext) {
            return new OAuth2FeignRequestInterceptor(oauth2ClientContext);
        }
    }

    @RestController
    class ServiceInstanceRestController {

        @Autowired
        private DiscoveryClient discoveryClient;

        @RequestMapping("/service-instances/{applicationName}")
        public Map<String, Object> serviceInstancesByApplicationName(
                @PathVariable String applicationName) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Response from ONE");
            response.put("serviceDiscoveryInstances", this.discoveryClient.getInstances(applicationName));
            return response;
        }
    }
}
