package com.fabiankevin.animeservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "anime", path = "anime")
public interface AnimeRepository extends JpaRepository<Anime, Long> {
}
