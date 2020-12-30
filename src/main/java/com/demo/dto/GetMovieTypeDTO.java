package com.demo.dto;

import lombok.Data;

@Data
public class GetMovieTypeDTO {

    private int rateType;
    private int runtimeType;
    private int releaseYearType;
    private int releaseMonthType;
    private int releaseDayType;
    private int releaseWeekdayType;

}
