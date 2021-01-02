package com.demo.mapper.neo4j;

import com.demo.pojo.neo4j.GetDTO.Command;
import com.demo.pojo.neo4j.GetDTO.GetCooperationDTO;
import com.demo.pojo.neo4j.GetDTO.GetSeriesMovieDTO;
import com.demo.pojo.neo4j.GetDTO.GetStatisticDTO;
import com.demo.pojo.neo4j.ReturnDTO.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Neo4jMovieMapper {

    List<Product> getTenProduct();
    List<SimpleProduct> getByTime(@Param("commands") List<Command> commands);
    List<SimpleMovie> getMovieByCondition(@Param("commands") List<Command> commands);

    MatchNum getMovieNumByCondition(@Param("commands") List<Command> commands);

    List<ReturnCooperationDTO> getCooperation(@Param("getCooperationDTO") GetCooperationDTO getCooperationDTO);

    List<ReturnCooperationDTO> getTopCooperation(@Param("getCooperationDTO") GetCooperationDTO getCooperationDTO);

    List<Statistic> getStatistic(@Param("getStatisticDTO") GetStatisticDTO getStasticDTO);

    List<MovieTitle> getSeriesMovie(@Param("getSeriesMovieDTO")GetSeriesMovieDTO getSeriesMovieDTO);
    List<SimpleProduct> getProductMovie(@Param("getSeriesMovieDTO")GetSeriesMovieDTO getSeriesMovieDTO);

    List<String> getMovieActor(@Param("value")String value);
    List<String> getMovieDirector(@Param("value")String value);
    List<String> getMovieGenre(@Param("value")String value);
}
