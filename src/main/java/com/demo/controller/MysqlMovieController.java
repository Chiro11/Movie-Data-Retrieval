package com.demo.controller;

import com.demo.dto.GetMovieDTO;
import com.demo.dto.ProductMoviePair;
import com.demo.pojo.JsonResult;
import com.demo.service.MysqlMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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

    @RequestMapping("/getMoviesCount")
    public ProductMoviePair getMoviesCount() {
        GetMovieDTO getMovieDTO = new GetMovieDTO();
//        getMovieDTO.setReleaseYear(2000);
//        getMovieDTO.setReleaseMonth(12);
//        getMovieDTO.setTitle("An American Christmas Carol");
//        return getMovieDTO.getReleaseYear();
        getMovieDTO.setDirector("Harry");
        return mysqlMovieService.getMovieCount(getMovieDTO);
    }
}