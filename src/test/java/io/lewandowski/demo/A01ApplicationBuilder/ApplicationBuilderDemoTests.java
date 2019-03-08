package io.lewandowski.demo.A01ApplicationBuilder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient.ResponseSpec;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ApplicationBuilderDemoTests {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {{"master"}, {"read-only"}});
    }

    private String runMode;

    public ApplicationBuilderDemoTests(String runMode) {
        this.runMode = runMode;
    }

    @Test
    public void applicationInReadOnly() {
        //Given
        System.setProperty("mode",runMode);
        ConfigurableApplicationContext context = ExerciseBuilderDemo.createContext().build().run();
        WebTestClient webTestClient = WebTestClient.bindToApplicationContext(context).build();

        //When
        ResponseSpec okResponse = webTestClient
                .get()
                .uri("/feature")
                .exchange();

        //Then
        okResponse
                .expectStatus().isOk()
                .expectBody().jsonPath("$.status").isEqualTo(runMode);

        context.close();
    }

}
