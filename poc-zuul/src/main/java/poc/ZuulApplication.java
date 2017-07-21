package poc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableOAuth2Sso
//@EnableEurekaClient
//@EnableZuulProxy
//@EnableResourceServer
@Slf4j
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
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
