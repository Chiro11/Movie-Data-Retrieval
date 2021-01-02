package com.demo.service;


import com.demo.pojo.neo4j.GetDTO.Command;
import com.demo.pojo.neo4j.GetDTO.GetCooperationDTO;
import com.demo.pojo.neo4j.GetDTO.GetSeriesMovieDTO;
import com.demo.pojo.neo4j.GetDTO.GetStatisticDTO;
import com.demo.pojo.neo4j.ReturnDTO.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Neo4jMovieService {

    List<Product> getTenProduct();
    List<SimpleProduct> getByTime(List<Command> commands);
    List<SimpleMovie> getMovieByCondition(List<Command>commands);

    MatchNum getMovieNumByCondition(List<Command> commands);

    List<ReturnCooperationDTO> getCooperation(GetCooperationDTO getCooperationDTO);

    List<ReturnCooperationDTO> getTopCooperation(GetCooperationDTO getCooperationDTO);

    List<Statistic> getStatistic(GetStatisticDTO getStasticDTO);

    List<MovieTitle> getSeriesMovie(GetSeriesMovieDTO getSeriesMovieDTO);

    List<SimpleProduct> getProductMovie(GetSeriesMovieDTO getSeriesMovieDTO);
}
