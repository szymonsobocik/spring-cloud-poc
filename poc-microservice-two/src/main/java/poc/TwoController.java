package poc;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TwoController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHelloWorld() {
        return "TWO: Hello World";
    }

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    public String getHello(@PathVariable("name") String name) {
        return "TWO: Hello " + name;
    }


}
