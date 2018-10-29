package com.develop.beer2js;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Beer2jsApplication {
	static String env;
	public static void main(String[] args) {
	    SpringApplication.run(Beer2jsApplication.class, args);
	}
}
