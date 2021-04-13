package com.fabiankevin.animeservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class AnimeServiceApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(AnimeServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}


//@RefreshScope
//@RestController
//class MessageController {
//
//	@Value("${test:Config server not working}")
//	public String sample;
//	@GetMapping("/message")
//	public String message(){
//		return sample;
//	}
//}
//}