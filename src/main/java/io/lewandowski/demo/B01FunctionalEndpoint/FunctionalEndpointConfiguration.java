package io.lewandowski.demo.B01FunctionalEndpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

//@Configuration
@RequiredArgsConstructor
public class FunctionalEndpointConfiguration {

    private final ThingRepository thingRepository;

    @Bean
    RouterFunction<ServerResponse> route(){
        return RouterFunctions.route(RequestPredicates.GET("/offers").or(RequestPredicates.GET("/offers-archival")), new HandlerFunction<ServerResponse>() {
            @Override
            public Mono<ServerResponse> handle(ServerRequest request) {
                return ServerResponse.ok().body(thingRepository.getOffers(), ThingDTO.class);
            }
        }).andRoute(RequestPredicates.GET("/offers/{id}"), new HandlerFunction<ServerResponse>() {
            @Override
            public Mono<ServerResponse> handle(ServerRequest request) {
                Long id = Long.valueOf(request.pathVariable("id"));
                return ServerResponse.ok().body(thingRepository.getOffer(id), ThingDTO.class);
            }
        }).andRoute(RequestPredicates.POST("/offers"), new HandlerFunction<ServerResponse>() {
            @Override
            public Mono<ServerResponse> handle(ServerRequest request) {
                Mono<ThingDTO> requestData = request.bodyToMono(ThingDTO.class);
                return ServerResponse.ok().body(thingRepository.save(requestData), ThingDTO.class);
            }
        });
    }
    //curl -X POST -H 'Content-Type: application/json' --data '{"id":1}' localhost:8080/offers
}
