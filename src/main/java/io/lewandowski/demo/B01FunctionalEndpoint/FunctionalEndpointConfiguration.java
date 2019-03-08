package io.lewandowski.demo.B01FunctionalEndpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

//@Configuration
@RequiredArgsConstructor
public class FunctionalEndpointConfiguration {

    private final ThingRepository thingRepository;

    @Bean
    RouterFunction<ServerResponse> route(){
        return RouterFunctions.route().build();
    }
}
