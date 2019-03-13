package io.lewandowski.demo.A01ApplicationBuilder;

import io.lewandowski.demo.services.FeatureReadOnlyEndpoint;
import io.lewandowski.demo.services.FeatureMasterEndpoint;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootApplication
public class ExerciseBuilder {

	public static void main(String[] args) {
		createContext()
				.build()
				.run(args);
	}

	/**
	 * Zaimplementuj funkcję createContext, która w zależności od zmiennej środowiskowej mode (przyjmuje wartości "read-only" lub "master" zarejestruje bean'a FeatureReadOnlyEndpoint lub FeatureMasterEndpoint
	 */
	static SpringApplicationBuilder createContext(){
		return new SpringApplicationBuilder();
	}
}
