package poc;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface TwoClientAPI {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String getHelloWorld();

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    String getHello(@PathVariable("name") String name);
}
