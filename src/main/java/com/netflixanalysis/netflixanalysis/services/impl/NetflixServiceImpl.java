package com.netflixanalysis.netflixanalysis.services.impl;

import com.netflixanalysis.netflixanalysis.domain.dto.*;
import com.netflixanalysis.netflixanalysis.repositories.NetflixRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.netflixanalysis.netflixanalysis.services.NetflixService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NetflixServiceImpl implements NetflixService {

    private final NetflixRepository netflixRepository;

    @Override
    public List<ContentTypeCountDto> getContentCountsByType() {
        List<Object[]> results = netflixRepository.countContentByType();

        return results.stream()
                .map(result -> ContentTypeCountDto.builder()
                        .type((String) result[0])
                        .count((Long) result[1])
                        .build()).collect(Collectors.toList());
    }

    @Override
    public List<MostFrequentRatingDto> getMostFrequentRatingsByType() {
        List<Object[]> results = netflixRepository.findMostFrequentRatingByType();

        return results.stream()
                .map(result -> MostFrequentRatingDto.builder()
                        .type((String) result[0])
                        .mostFrequentRating((String) result[1])
                        .ratingCount((Long) result[2])
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<ContentByYearDto> getContentByReleaseYear(String year) {
        List<Object[]> results = netflixRepository.findContentByReleaseYear(year);

        return results.stream()
                .map(result -> ContentByYearDto.builder()
                      .type((String) result[0])
                      .title((String) result[1])
                      .duration((String) result[2])
                      .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<TopCountryDto> getTopXCountriesByContent(Integer top) {
        List<Object[]> results = netflixRepository.findTopXCountriesByContent(top);

        return results.stream()
                .map(result -> TopCountryDto.builder()
                        .country((String) result[0])
                        .totalContent((Long) result[1])
                        .build())
                .collect(Collectors.toList());
    }


    @Override
    public List<LongestMovieTvShowDto> findLongestMovieAndTvShow() {
        List<Object[]> results = netflixRepository.findLongestMovieAndTvShow();

        return results.stream()
                .map(result -> LongestMovieTvShowDto.builder()
                        .type((String) result[0])
                        .title((String) result[1])
                        .duration((String) result[2])
                        .description((String) result[3])
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<TopMovieActorDto> getTop10MovieActor(String country) {
        List<Object[]> results = netflixRepository.getTop10MovieActor(country);

        return results.stream()
                .map(result -> TopMovieActorDto.builder()
                        .actor((String) result[0])
                        .movieCount((Long) result[1]).build())
                .collect(Collectors.toList());
    }

    @Override
    public List<LabelContentDto> labelTheContent() {
        List<Object[]> results = netflixRepository.labelTheContent();

        return results.stream()
                .map(result -> LabelContentDto.builder()
                        .category((String) result[0])
                        .contentCount((Long) result[1]).build())
                .collect(Collectors.toList());

    }
}
