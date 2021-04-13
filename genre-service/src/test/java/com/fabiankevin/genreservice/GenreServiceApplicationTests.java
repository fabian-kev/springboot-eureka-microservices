package com.fabiankevin.genreservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;


class GenreServiceApplicationTests {

	@Test
	void contextLoads() {
		IntStream.range(0, 25).forEach(i -> {
			System.out.println( (Math.random() * 25)  );
		});
	}

}
