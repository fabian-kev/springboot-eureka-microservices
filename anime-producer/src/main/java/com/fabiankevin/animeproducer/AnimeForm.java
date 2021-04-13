package com.fabiankevin.animeproducer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnimeForm {
    private Long id;
    private String name;
    private Integer episode;
    private Long genreId;
}

