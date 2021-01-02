package com.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetMovieTypeDTO {

    private int rateType;
    private int runtimeType;
    private int releaseYearType;
    private int releaseMonthType;
    private int releaseDayType;
    private int releaseWeekdayType;

}
