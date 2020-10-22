package net.appen.weather;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppenWeatherApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AppenWeatherApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}

}
