package com.demo.dto;

import lombok.Data;

@Data
public class GetMovieDTO {

    private String title;
    private String productId;
    private double rate;
    private int runtime;
    private int releaseYear;
    private int releaseMonth;
    private int releaseDay;
    private int releaseWeekday;
    private String language;
    private String format;
    private String genre;
    private String director;
    private String actor;

}
