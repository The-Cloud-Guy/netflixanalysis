package com.netflixanalysis.netflixanalysis.domain.dto;

import lombok.Builder;

@Builder
public record ContentByYearDto(String type, String title, String duration) {
}
