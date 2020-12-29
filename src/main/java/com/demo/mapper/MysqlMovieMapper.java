package com.demo.mapper;

import com.demo.dto.GetMovieDTO;
import com.demo.dto.ProductMoviePair;
import com.demo.pojo.JsonResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MysqlMovieMapper {

    public ProductMoviePair getMoviesCount(@Param("getMovieDTO") GetMovieDTO getMovieDTO);
}
