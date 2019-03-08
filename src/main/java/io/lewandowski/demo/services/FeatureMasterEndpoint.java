package io.lewandowski.demo.services;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FeatureMasterEndpoint {

    @GetMapping("/feature")
    Mono<ResponseDTO> featureBEndpoint(){
        return Mono.just(new ResponseDTO("master"));
    }
}
