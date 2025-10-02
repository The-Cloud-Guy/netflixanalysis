package com.netflixanalysis.netflixanalysis.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Table(name = "netflix")
public class Netflix {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10)
    private String show_id;

    @Column(length = 10)
    private String type;

    @Column(length = 250)
    private String title;

    @Column(length = 600)
    private String director;

    @Column(length = 1100)
    private String casts;

    @Column(length = 60)
    private String country;

    @Column(length = 60)
    private String date_added;

    @Column(length = 100)
    private String release_year;

    @Column(length = 20)
    private String rating;

    @Column(length = 20)
    private String duration;

    @Column(length = 300)
    private String listed_in;

    @Column(length = 600)
    private String description;
}
