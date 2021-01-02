package com.demo.service.impl;

import com.demo.dto.GetMovieDTO;
import com.demo.dto.GetMovieTypeDTO;
import com.demo.dto.PageDataDTO;
import com.demo.dto.ReturnMovieDTO;
import com.demo.pojo.MoviesCountResult;
import com.demo.mapper.mysql.MysqlMovieMapper;
import com.demo.service.MysqlMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
//    public ProductMoviePair getMovieCount(GetMovieDTO getMovieDTO) {
//        return mysqlMovieMapper.getMoviesCount(getMovieDTO);
//    }
    @Override
    public MoviesCountResult getMoviesCount(GetMovieDTO getMovieDTO, GetMovieTypeDTO getMovieTypeDTO) {
        return mysqlMovieMapper.getMoviesCount(getMovieDTO, getMovieTypeDTO);
    }

    @Override
    public List<ReturnMovieDTO> getMovieList(GetMovieDTO getMovieDTO,
                                     GetMovieTypeDTO getMovieTypeDTO,
                                     PageDataDTO pageDataDTO) {
        int startPos = (pageDataDTO.getPageNum()-1)*pageDataDTO.getPageSize();
        return mysqlMovieMapper.getMovieList(getMovieDTO, getMovieTypeDTO, startPos, pageDataDTO.getPageSize());
    }
}
