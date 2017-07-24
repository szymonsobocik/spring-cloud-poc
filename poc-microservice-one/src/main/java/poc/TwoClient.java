package poc;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("poc-microservice-two")
public interface TwoClient {

    @RequestMapping(value = "/resource", method = RequestMethod.GET)
    String getResource();
}
