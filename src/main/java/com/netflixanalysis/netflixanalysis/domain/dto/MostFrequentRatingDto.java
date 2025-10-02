package com.netflixanalysis.netflixanalysis.domain.dto;

import lombok.Builder;

@Builder
public record MostFrequentRatingDto(String type, String mostFrequentRating, Long ratingCount) {
}
