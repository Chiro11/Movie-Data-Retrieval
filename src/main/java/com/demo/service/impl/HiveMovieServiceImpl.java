package com.demo.service.impl;

import com.demo.dto.GetMovieDTO;
import com.demo.dto.GetMovieTypeDTO;
import com.demo.pojo.MoviesCountResult;
import com.demo.pojo.ProductMoviePair;
import com.demo.mapper.HiveMovieMapper;
import com.demo.service.HiveMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class HiveMovieServiceImpl implements HiveMovieService {

    @Autowired
    HiveMovieMapper hiveMovieMapper;

    @Override
    public MoviesCountResult test(GetMovieDTO getMovieDTO,
                                  GetMovieTypeDTO getMovieTypeDTO,
                                  JdbcTemplate jdbcTemplate) {
        return hiveMovieMapper.test(getMovieDTO, getMovieTypeDTO, jdbcTemplate);
    }

    @Override
    public MoviesCountResult getMoviesCount(GetMovieDTO getMovieDTO,
                                            GetMovieTypeDTO getMovieTypeDTO,
                                            JdbcTemplate jdbcTemplate) {
        return hiveMovieMapper.getMoviesCount(getMovieDTO, getMovieTypeDTO, jdbcTemplate);
    }
}
