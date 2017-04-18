package poc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceTwoApplication.class, args);
    }


    @RestController
    class ServiceInstanceRestController {

        @Autowired
        private DiscoveryClient discoveryClient;

        @RequestMapping("/service-instances/{applicationName}")
        public Map<String, Object> serviceInstancesByApplicationName(
                @PathVariable String applicationName) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Response from TWO");
            response.put("serviceDiscoveryInstances", this.discoveryClient.getInstances(applicationName));
            return response;
        }
    }
}
