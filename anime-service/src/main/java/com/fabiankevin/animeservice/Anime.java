package com.fabiankevin.animeservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Anime {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer episode;
    private String genre;
}
