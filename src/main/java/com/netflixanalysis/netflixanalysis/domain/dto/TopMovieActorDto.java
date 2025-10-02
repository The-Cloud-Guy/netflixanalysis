package com.netflixanalysis.netflixanalysis.domain.dto;

import lombok.Builder;

@Builder
public record TopMovieActorDto(String actor, Long movieCount) {
}
