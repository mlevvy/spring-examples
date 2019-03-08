package io.lewandowski.demo.B01FunctionalEndpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static java.lang.Long.valueOf;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
@RequiredArgsConstructor
public class ExerciseEndpointConfiguration {

    private final ThingRepository thingRepository;

    /**
     * Zbuduj dwa endpointy "/oranges/{id}" oraz "/apples/{id}", które będą wywoływały funkcję "thingRepository.getOffer(id)"
     */
    @Bean
    RouterFunction<ServerResponse> route(){
        return RouterFunctions.route().build();
    }
}
