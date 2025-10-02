package com.netflixanalysis.netflixanalysis.repositories;

import com.netflixanalysis.netflixanalysis.domain.entities.Netflix;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface NetflixRepository extends JpaRepository<Netflix, Long> {

    @Query(value = """
            SELECT
                  type,
                  COUNT(*)
            FROM netflix
            GROUP BY type
            """, nativeQuery=true)
    List<Object[]> countContentByType();


    @Query(value = """
        WITH RatingCounts AS (
            SELECT 
                type,
                rating,
                COUNT(*) AS rating_count
            FROM netflix
            GROUP BY type, rating
        ),
        RankedRatings AS (
            SELECT 
                type,
                rating,
                rating_count,
                DENSE_RANK() OVER (PARTITION BY type ORDER BY rating_count DESC) AS rank
            FROM RatingCounts
        )
        SELECT 
            type,
            rating AS most_frequent_rating,
            rating_count
        FROM RankedRatings
        WHERE rank IN (1,2,3)
        """, nativeQuery = true)
    List<Object[]> findMostFrequentRatingByType();


    @Query(value = """
        SELECT type,
               title,
               duration
        FROM netflix
        WHERE release_year = :year
        """, nativeQuery = true)
    List<Object[]> findContentByReleaseYear(@Param("year") String year);


    @Query(value = """
        WITH countries AS (
            SELECT UNNEST(STRING_TO_ARRAY(country, ',')) AS country
            FROM netflix
        )
        SELECT TRIM(country) as country, COUNT(*) AS total_content
        FROM countries
        WHERE country IS NOT NULL AND TRIM(country) <> ''
        GROUP BY TRIM(country)
        ORDER BY total_content DESC
        LIMIT :top
        """, nativeQuery = true)
    List<Object[]> findTopXCountriesByContent(@Param("top") Integer top);


    @Query(value = """
        WITH tv AS (
                SELECT type, title, duration, description
                FROM netflix
                WHERE type = 'TV Show' AND duration IS NOT NULL
                  AND SPLIT_PART(duration, ' ', 1)::INT > 5
            	  LIMIT 2
        ),
        movie AS (
                SELECT type, title, duration, description
                FROM netflix
                WHERE type = 'Movie' AND duration IS NOT NULL
                ORDER BY SPLIT_PART(duration, ' ', 1)::INT DESC
                LIMIT 2
        )
        SELECT * FROM tv
        UNION ALL
        SELECT * FROM movie;
        """, nativeQuery = true)
    List<Object[]> findLongestMovieAndTvShow();


    @Query(value = """
        SELECT
                UNNEST(STRING_TO_ARRAY(casts, ',')) AS actor,
                COUNT(*)
        FROM netflix
        WHERE country = :country
        GROUP BY actor
        ORDER BY COUNT(*) DESC
        LIMIT 10;
        """, nativeQuery = true)
    List<Object[]> getTop10MovieActor(@Param("country") String country);


    @Query(value = """
        SELECT
                category,
                COUNT(*) AS content_count
        FROM (
                SELECT
                    CASE
                        WHEN description ILIKE '%kill%'
            		     	OR description ILIKE '%violence%'
            				  OR description ILIKE '%kill%'
            				    OR description ILIKE '%dead%' THEN 'Not familly-friendly content'
                        ELSE 'Familly friendly content'
                    END AS category
                FROM netflix
            ) AS categorized_content
        GROUP BY category;
        """, nativeQuery = true)
    List<Object[]> labelTheContent();




}
