package com.netflixanalysis.netflixanalysis.domain.dto;

import lombok.Builder;
import lombok.Data;

@Builder
public record ContentTypeCountDto(String type, Long count) {
}
