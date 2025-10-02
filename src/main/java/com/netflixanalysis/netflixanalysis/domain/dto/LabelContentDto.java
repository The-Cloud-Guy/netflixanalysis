package com.netflixanalysis.netflixanalysis.domain.dto;

import lombok.Builder;

@Builder
public record LabelContentDto(String category, Long contentCount) {
}
