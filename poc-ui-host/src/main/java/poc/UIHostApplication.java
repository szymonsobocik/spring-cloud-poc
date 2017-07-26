package poc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@Slf4j
@SpringBootApplication
@EnableOAuth2Sso
@EnableZuulProxy
public class UIHostApplication {

    public static void main(String[] args) {
        SpringApplication.run(UIHostApplication.class, args);
    }
}
