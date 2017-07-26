package poc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OneController {

    private final TwoClient twoClient;

    @Autowired
    public OneController(TwoClient twoClient) {
        this.twoClient = twoClient;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloOne() {
        log.info("Hello One");
        return "Hello from One";
    }

    @RequestMapping("/details")
    public Authentication details(Authentication authentication) {
        log.info("Authentication from One: {}", authentication);
        return authentication;
    }

    @RequestMapping(value = "/resource", method = RequestMethod.GET)
    public String getResource() {
        log.info("Hello in ONE");
        String resource = twoClient.getResource();
        log.info("I'm in poc-microservice-one and received resource from TWO: {}", resource);
        return "I'm in poc-microservice-one and received resource from TWO: " + resource;
    }
}
