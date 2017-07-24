package poc;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TwoController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHelloWorld() {
        return "Hello from TWO";
    }

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    public String getHello(@PathVariable("name") String name) {
        return "TWO: Hello " + name;
    }

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public Authentication getHello(Authentication authentication) {
        return authentication;
    }

    @RequestMapping(value = "/resource", method = RequestMethod.GET)
    public String getResource() {
        return "Some resource from TWO";
    }

}
