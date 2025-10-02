package com.netflixanalysis.netflixanalysis.domain.dto;

import lombok.Builder;

@Builder
public record LongestMovieTvShowDto(String type, String title, String duration, String description ) {
}
