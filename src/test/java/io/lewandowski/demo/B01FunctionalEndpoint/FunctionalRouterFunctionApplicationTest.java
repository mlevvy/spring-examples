package io.lewandowski.demo.B01FunctionalEndpoint;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Arrays;
import java.util.Collection;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FunctionalRouterFunctionApplication.class)
public class FunctionalRouterFunctionApplicationTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void bothEndpoint() {
        WebTestClient webTestClient = WebTestClient.bindToApplicationContext(applicationContext).build();

        WebTestClient.ResponseSpec oranges = webTestClient.get().uri("/oranges/1").exchange();
        WebTestClient.ResponseSpec apples = webTestClient.get().uri("/apples/1").exchange();

        apples.expectStatus().isOk();
        oranges.expectStatus().isOk();

        oranges.expectBody().jsonPath("$.id").isEqualTo(1L);

    }
}