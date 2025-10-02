package com.netflixanalysis.netflixanalysis.controllers;

import com.netflixanalysis.netflixanalysis.domain.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.netflixanalysis.netflixanalysis.services.NetflixService;

import java.util.List;

@RestController
@RequestMapping("api/v1/netflixanalysis")
@RequiredArgsConstructor
public class NetflixController {

    private final NetflixService netflixService;

    @GetMapping("/content-counts")
    public ResponseEntity<GenericApiResponse<List<ContentTypeCountDto>>> getContentCounts(){

            List<ContentTypeCountDto> countsResult = netflixService.getContentCountsByType();
            return ResponseEntity.ok(GenericApiResponse.success(countsResult));
    }

    @GetMapping("/most-frequent-ratings")
    public ResponseEntity<GenericApiResponse<List<MostFrequentRatingDto>>> getMostFrequentRatings() {

            List<MostFrequentRatingDto> ratings = netflixService.getMostFrequentRatingsByType();
            return ResponseEntity.ok(GenericApiResponse.success(ratings));
    }

    @GetMapping("/content-by-year")
    public ResponseEntity<GenericApiResponse<List<ContentByYearDto>>> getContentByYear(@RequestParam String year) {

            List<ContentByYearDto> content = netflixService.getContentByReleaseYear(year);
            return ResponseEntity.ok(GenericApiResponse.success(content));
    }

    @GetMapping("/top-countries")
    public ResponseEntity<GenericApiResponse<List<TopCountryDto>>> getTopXCountries(@RequestParam Integer top) {

            List<TopCountryDto> countries = netflixService.getTopXCountriesByContent(top);
            return ResponseEntity.ok(GenericApiResponse.success(countries));
    }

    @GetMapping("/longest-content")
    public ResponseEntity<GenericApiResponse<List<LongestMovieTvShowDto>>> findLongestMovieAndTvShow() {

            List<LongestMovieTvShowDto> longestContent = netflixService.findLongestMovieAndTvShow();
            return ResponseEntity.ok(GenericApiResponse.success(longestContent));
    }

    @GetMapping("/top-actors-per-country")
    public ResponseEntity<GenericApiResponse<List<TopMovieActorDto>>> getTop10MovieActor(@RequestParam String country){

            List<TopMovieActorDto> topMovieActor = netflixService.getTop10MovieActor(country);
            return ResponseEntity.ok(GenericApiResponse.success(topMovieActor));
    }

    @GetMapping("/labeled-content")
    public ResponseEntity<GenericApiResponse<List<LabelContentDto>>> labelTheContent(){

            List<LabelContentDto> labeledContent = netflixService.labelTheContent();
            return ResponseEntity.ok(GenericApiResponse.success(labeledContent));
    }




}
