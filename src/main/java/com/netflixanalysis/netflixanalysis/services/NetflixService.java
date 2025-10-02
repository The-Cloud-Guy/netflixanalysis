package com.netflixanalysis.netflixanalysis.services;

import com.netflixanalysis.netflixanalysis.domain.dto.*;

import java.util.List;

public interface NetflixService {
    List<ContentTypeCountDto> getContentCountsByType();
    List<MostFrequentRatingDto> getMostFrequentRatingsByType();
    List<ContentByYearDto> getContentByReleaseYear(String year);
    public List<TopCountryDto> getTopXCountriesByContent(Integer top);
    List<LongestMovieTvShowDto>  findLongestMovieAndTvShow();
    List<TopMovieActorDto> getTop10MovieActor(String country);
    List<LabelContentDto> labelTheContent();
}
