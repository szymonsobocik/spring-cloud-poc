package poc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@SpringBootApplication
//@EnableOAuth2Sso
@EnableResourceServer
@EnableEurekaClient
@EnableZuulProxy
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @RestController
    class MainController {

        @RequestMapping("/hello")
        public String hello() {
            return "Hello World from Zuul";
        }

        @RequestMapping("/details")
        public Authentication details(Authentication authentication) {
            log.info("Authentication: {}", authentication);
            return authentication;
        }

    }
}
