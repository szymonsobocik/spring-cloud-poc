package poc;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("poc-microservice-two")
public interface TwoClient {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String getHelloWorld();

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    String getHello(@PathVariable("name") String name);
}
