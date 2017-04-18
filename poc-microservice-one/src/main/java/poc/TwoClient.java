package poc;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("trf-microservice-two")
public interface TwoClient extends TwoClientAPI {

}
