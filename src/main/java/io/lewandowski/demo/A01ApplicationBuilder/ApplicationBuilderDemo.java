package io.lewandowski.demo.A01ApplicationBuilder;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.GenericApplicationContext;

import java.util.function.Supplier;

@SpringBootApplication
public class ApplicationBuilderDemo {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationBuilderDemo.class, args);
	}

	@Bean
	ApplicationRunner featureA(){
		return it -> System.out.println("Feature A is working");
	}

	@Bean
	ApplicationRunner featureB(){
		return it -> System.out.println("Feature B is working");
	}

}
