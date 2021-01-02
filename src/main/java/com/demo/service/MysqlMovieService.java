package com.demo.service;

import com.demo.dto.GetMovieDTO;
import com.demo.dto.GetMovieTypeDTO;
import com.demo.dto.PageDataDTO;
import com.demo.dto.ReturnMovieDTO;
import com.demo.pojo.MoviesCountResult;

import java.util.List;

public interface MysqlMovieService {
//    public JsonResult getMovies(GetMovieDTO getMovieDTO);
//    public ProductMoviePair getMovieCount(GetMovieDTO getMovieDTO);
    public MoviesCountResult getMoviesCount(GetMovieDTO getMovieDTO,
                                       GetMovieTypeDTO getMovieTypeDTO);

    public List<ReturnMovieDTO> getMovieList(GetMovieDTO getMovieDTO,
                                             GetMovieTypeDTO getMovieTypeDTO,
                                             PageDataDTO pageDataDTO);

}
