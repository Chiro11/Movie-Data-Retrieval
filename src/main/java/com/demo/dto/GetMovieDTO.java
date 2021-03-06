package com.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
