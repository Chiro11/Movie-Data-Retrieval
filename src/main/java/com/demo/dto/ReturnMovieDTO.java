package com.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnMovieDTO {

    private String title;
    private String productId;
    private double rate;
    private int runtime;
    private int releaseYear;
    private int releaseMonth;
    private int releaseDay;

}
