package com.demo.controller;

import com.demo.dto.*;
import com.demo.pojo.JsonResult;
import com.demo.pojo.MoviesCountResult;
import com.demo.service.MysqlMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mysql")
public class MysqlMovieController {
    @Autowired
    MysqlMovieService mysqlMovieService;

    @RequestMapping("/hello")
    public boolean index() {
        String str = new String();
        return str.isEmpty();
    }

//    @RequestMapping("/check")
//    public int getMovieNumber() {
//        return mysqlMovieService.getNumberByName("Forrest Gump");
//    }

//    @RequestMapping("/getMovies")
//    public JsonResult getMovies(GetMovieDTO getMovieDTO) {
//        return mysqlMovieService.getMovies(getMovieDTO);
//    }

    @PostMapping("/getMoviesCount")
    public JsonResult getMoviesCount(@RequestBody GetMovieAllDTO getMovieAllDTO) {
        GetMovieDTO getMovieDTO = new GetMovieDTO(getMovieAllDTO.getTitle(),
                getMovieAllDTO.getProductId(),
                getMovieAllDTO.getRate(),
                getMovieAllDTO.getRuntime(),
                getMovieAllDTO.getReleaseYear(),
                getMovieAllDTO.getReleaseMonth(),
                getMovieAllDTO.getReleaseDay(),
                getMovieAllDTO.getReleaseWeekday(),
                getMovieAllDTO.getLanguage(),
                getMovieAllDTO.getFormat(),
                getMovieAllDTO.getGenre(),
                getMovieAllDTO.getDirector(),
                getMovieAllDTO.getActor());
        GetMovieTypeDTO getMovieTypeDTO = new GetMovieTypeDTO(getMovieAllDTO.getRateType(),
                getMovieAllDTO.getRuntimeType(),
                getMovieAllDTO.getReleaseYearType(),
                getMovieAllDTO.getReleaseMonthType(),
                getMovieAllDTO.getReleaseDayType(),
                getMovieAllDTO.getReleaseWeekdayType());
        long startTime = System.currentTimeMillis();
        MoviesCountResult mr = mysqlMovieService.getMoviesCount(getMovieDTO, getMovieTypeDTO);
        long endTime = System.currentTimeMillis();
        return new JsonResult("ok", endTime-startTime, mr);
    }

    @RequestMapping("/getMovieList")
    public JsonResult getMovieList(GetMovieDTO getMovieDTO, GetMovieTypeDTO getMovieTypeDTO, PageDataDTO pageDataDTO) {
        pageDataDTO.setPageNum(2);
        pageDataDTO.setPageSize(10);
        getMovieDTO.setTitle("Harry");
        long startTime = System.currentTimeMillis();
        List<String> titles = mysqlMovieService.getMovieList(getMovieDTO, getMovieTypeDTO, pageDataDTO);
        long endTime = System.currentTimeMillis();
        return new JsonResult("ok", endTime-startTime, titles);
    }
}