package pl.mrs.movie_raiting_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MovieRaitingSystemApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MovieRaitingSystemApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieRaitingSystemApplication.class, args);
	}
}
