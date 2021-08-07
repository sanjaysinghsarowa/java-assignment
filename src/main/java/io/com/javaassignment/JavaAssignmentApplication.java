package io.com.javaassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@ComponentScan("io.com.javaassignment")
@SpringBootApplication
@EnableJpaRepositories("io.com.javaassignment")
@EntityScan("io.com.javaassignment")
public class JavaAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaAssignmentApplication.class, args);
	}

}
