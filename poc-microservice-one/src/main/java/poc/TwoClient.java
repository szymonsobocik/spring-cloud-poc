package poc;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("poc-microservice-two")
public interface TwoClient extends TwoClientAPI {

}
