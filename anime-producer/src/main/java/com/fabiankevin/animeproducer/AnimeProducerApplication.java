package com.fabiankevin.animeproducer;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AnimeProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimeProducerApplication.class, args);
	}

}


@RestController
@RequiredArgsConstructor
@RequestMapping("anime-producer")
class AnimeProduceController {


	private final AnimeService animeService;
	private final GenreService genreService;

	@PostMapping
	public Anime create(@RequestBody AnimeForm animeForm){
		System.out.println(animeForm);
		Genre genre = genreService.getById(animeForm.getGenreId());
		if( genre == null ){
		    throw new RuntimeException("Sorry, We're unable to find genre");
        }
		System.out.println(genre);
		return animeService.create(
				Anime.builder()
				.episode(animeForm.getEpisode())
				.name(animeForm.getName())
				.genre(genre.getName())
				.build()
		);
	}


	@GetMapping("/users")


}

@FeignClient("anime")
interface AnimeService {
	@PostMapping("/anime")
	Anime create(@RequestBody Anime anime);
}
@FeignClient("genre")
interface GenreService {
	@GetMapping("/genre/{id}")
	Genre getById(@PathVariable("id") Long id);
}