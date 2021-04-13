package com.fabiankevin.genreservice;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "genre", collectionResourceRel = "genre")
public interface AnimeRepository extends PagingAndSortingRepository<Genre, Long> {
}
