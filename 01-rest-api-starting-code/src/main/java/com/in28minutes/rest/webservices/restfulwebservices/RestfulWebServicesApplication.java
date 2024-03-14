package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}

    @Bean
    WebMvcConfigurer corsConfigure() {
		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// TODO Auto-generated method stub
//					registry.addMapping("/**")
//					.allowedMethods("*")
//					.allowedOrigins("http://localhost:3000");
				
				registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // Update this with your frontend URL
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*");
			}
			
		};
	}

}
