package com.fabiankevin.genreservice;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
@EnableDiscoveryClient
@RequiredArgsConstructor
public class GenreServiceApplication implements CommandLineRunner {
	private final AnimeRepository animeRepository;
	public static void main(String[] args) {
		SpringApplication.run(GenreServiceApplication.class, args);
	}


	@PostConstruct
	public void load(){
		Arrays.asList(
				Genre.builder().name("COMEDY").build(),
				Genre.builder().name("FANTASY").build(),
				Genre.builder().name("ACTION").build()
		).forEach(animeRepository::save);
	}


	@Value("${message:no message}")
	public String message;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("message: "+message);
	}
}



