package com.demo.mapper.mysql;

import com.demo.dto.*;
import com.demo.pojo.MoviesCountResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MysqlMovieMapper {

    public MoviesCountResult getMoviesCount(@Param("getMovieDTO") GetMovieDTO getMovieDTO,
                                  @Param("getMovieTypeDTO") GetMovieTypeDTO getMovieTypeDTO);

    public List<ReturnMovieDTO> getMovieList(@Param("getMovieDTO") GetMovieDTO getMovieDTO,
                                             @Param("getMovieTypeDTO") GetMovieTypeDTO getMovieTypeDTO,
                                             @Param("startPos") int startPos,
                                             @Param("listSize") int listSize);

    public List<ReturnReviewDTO> getReviewList(@Param("productId") String productId);

}
