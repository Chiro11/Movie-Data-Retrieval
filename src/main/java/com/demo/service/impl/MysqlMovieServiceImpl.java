package com.demo.service.impl;

import com.demo.dto.GetMovieDTO;
import com.demo.dto.ProductMoviePair;
import com.demo.mapper.MysqlMovieMapper;
import com.demo.pojo.JsonResult;
import com.demo.service.MysqlMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MysqlMovieServiceImpl implements MysqlMovieService {
    @Autowired
    MysqlMovieMapper mysqlMovieMapper;

//    public int getNumberByName(String MovieName) {
//        return mysqlMovieMapper.getNumberByName(MovieName);
//    }
//    public JsonResult getMovies(GetMovieDTO getMovieDTO) {
//        return mysqlMovieMapper.getMovies(getMovieDTO);
//    }
    public ProductMoviePair getMovieCount(GetMovieDTO getMovieDTO) {
        return mysqlMovieMapper.getMoviesCount(getMovieDTO);
    }
}
