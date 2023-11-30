package eti.mecka.franciszek.project;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;

@SpringBootApplication
public class ProjectOrganizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectOrganizationApplication.class, args);
	}

//	${labs.player.url} crashes the bean for some reason
	@Bean
	public RestTemplate restTemplate(@Value("http://localhost:8081") String baseUrl) {
		return new RestTemplateBuilder().rootUri(baseUrl).build();
	}
}
