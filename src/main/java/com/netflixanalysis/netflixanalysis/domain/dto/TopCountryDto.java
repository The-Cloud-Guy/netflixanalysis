package com.netflixanalysis.netflixanalysis.domain.dto;

import lombok.Builder;

@Builder
public record TopCountryDto(String country, Long totalContent) {
}
