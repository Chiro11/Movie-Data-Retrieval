package com.demo.service;

import com.demo.dto.GetMovieDTO;
import com.demo.dto.GetMovieTypeDTO;
import com.demo.pojo.MoviesCountResult;
import org.springframework.jdbc.core.JdbcTemplate;

public interface HiveMovieService {

    public MoviesCountResult test(GetMovieDTO getMovieDTO,
                                  GetMovieTypeDTO getMovieTypeDTO,
                                  JdbcTemplate jdbcTemplate);

    public MoviesCountResult getMoviesCount(GetMovieDTO getMovieDTO,
                                            GetMovieTypeDTO getMovieTypeDTO,
                                            JdbcTemplate jdbcTemplate);
}
