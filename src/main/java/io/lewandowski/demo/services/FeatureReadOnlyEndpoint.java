package io.lewandowski.demo.services;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FeatureReadOnlyEndpoint {

    @GetMapping("/feature")
    Mono<ResponseDTO> featureAEndpoint(){
        return Mono.just(new ResponseDTO("read-only"));
    }
}
