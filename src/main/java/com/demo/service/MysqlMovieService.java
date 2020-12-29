package com.demo.service;

import com.demo.dto.GetMovieDTO;
import com.demo.dto.ProductMoviePair;
import com.demo.pojo.JsonResult;

public interface MysqlMovieService {
//    public JsonResult getMovies(GetMovieDTO getMovieDTO);
    public ProductMoviePair getMovieCount(GetMovieDTO getMovieDTO);
}
