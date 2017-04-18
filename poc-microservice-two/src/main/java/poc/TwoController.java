package poc;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TwoController implements TwoClientAPI {

    @Override
    public String getHelloWorld() {
        return "TWO: Hello World";
    }

    @Override
    public String getHello(@PathVariable("name") String name) {
        return "TWO: Hello " + name;
    }


}
