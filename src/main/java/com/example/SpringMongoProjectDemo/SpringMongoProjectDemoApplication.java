package com.example.SpringMongoProjectDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableSwagger2
@EnableMongoRepositories("com.example.SpringMongoProjectDemo.repository")
@SpringBootApplication
@ComponentScan("com.example.*")
public class SpringMongoProjectDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoProjectDemoApplication.class, args);
	}

}
