package com.demo.service;

import com.demo.dto.*;
import com.demo.pojo.MoviesCountResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MysqlMovieService {
//    public JsonResult getMovies(GetMovieDTO getMovieDTO);
//    public ProductMoviePair getMovieCount(GetMovieDTO getMovieDTO);
    public MoviesCountResult getMoviesCount(GetMovieDTO getMovieDTO,
                                       GetMovieTypeDTO getMovieTypeDTO);

    public List<ReturnMovieDTO> getMovieList(GetMovieDTO getMovieDTO,
                                             GetMovieTypeDTO getMovieTypeDTO,
                                             PageDataDTO pageDataDTO);

    public List<ReturnReviewDTO> getReviewList(String productId);

}
