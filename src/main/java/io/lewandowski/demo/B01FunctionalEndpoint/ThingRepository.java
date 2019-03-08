package io.lewandowski.demo.B01FunctionalEndpoint;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
class ThingRepository {
    Flux<ThingDTO> getOffers(){
        return Flux.just(new ThingDTO(1L));
    }

    Mono<ThingDTO> getOffer(Long id){
        return Mono.just(new ThingDTO(id));
    }

    Mono<ThingDTO> save(Mono<ThingDTO> offer) {
        return offer;
    }
}
