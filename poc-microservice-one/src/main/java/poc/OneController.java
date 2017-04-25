package poc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String getHelloWorld() {
        log.info("Hello world in ONE");
        String helloWorld = twoClient.getHelloWorld();
        log.info("Received from TWO: {}", helloWorld);
        return helloWorld;
    }

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    public String getHello(@PathVariable("name") String name) {
        log.info("Hello in ONE");
        String helloWorld = twoClient.getHello(name);
        log.info("Received from TWO: {}", helloWorld);
        return helloWorld;
    }
}
