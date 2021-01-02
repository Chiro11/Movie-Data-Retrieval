package com.demo.mapper;

import com.demo.dto.GetMovieDTO;
import com.demo.dto.GetMovieTypeDTO;
import com.demo.pojo.MoviesCountResult;
import org.apache.ibatis.annotations.Mapper;
import org.mortbay.component.Container;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public class HiveMovieMapper {

    public MoviesCountResult test(GetMovieDTO getMovieDTO,
                                  GetMovieTypeDTO getMovieTypeDTO,
                                  JdbcTemplate jdbcTemplate) {
        String sql = "select count(*), count(distinct title) from product";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        MoviesCountResult mcr = new MoviesCountResult();
        Map<String, Object> mp = list.get(0);
        int cur = 0;
        for(Object value: mp.values()) {
            if(cur==0)
                mcr.setProductCount(Integer.parseInt(value.toString()));
            else
                mcr.setMovieCount(Integer.parseInt(value.toString()));
            cur++;
        }
        return mcr;
    }

    public MoviesCountResult getMoviesCount(GetMovieDTO getMovieDTO,
                                       GetMovieTypeDTO getMovieTypeDTO,
                                       JdbcTemplate jdbcTemplate) {
        String sql = "select * from product";
        if(getMovieDTO.getLanguage()!=null)
            sql += " inner join languageof on (product.productid=languageof.productid)";
        if(getMovieDTO.getGenre()!=null)
            sql += " inner join classify on (classify.movie=product.title)";
        if(getMovieDTO.getDirector()!=null)
            sql += " inner join direct on (direct.movie=product.title)";
        if(getMovieDTO.getActor()!=null)
            sql += " inner join act on (act.movie=product.title)";
        boolean flag = false;
        if(getMovieDTO.getTitle()!=null) {
            sql += flag?" and":" where";
            flag = true;
            sql += " title regexp('.*"+getMovieDTO.getTitle()+".*')";
        }
        if(getMovieDTO.getProductId()!=null) {
            sql += flag?" and":" where";
            flag = true;
            sql += " productid regexp('.*"+getMovieDTO.getProductId()+".*')";
        }
        if(getMovieTypeDTO.getRateType()==1) {
            sql += flag?" and":" where";
            flag = true;
            sql += " rate>="+getMovieDTO.getRate();
        }
        else if(getMovieTypeDTO.getRateType()==2) {
            sql += flag?" and":" where";
            flag = true;
            sql += " rate="+getMovieDTO.getRate();
        }
        else if(getMovieTypeDTO.getRateType()==3) {
            sql += flag?" and":" where";
            flag = true;
            sql += " rate<="+getMovieDTO.getRate();
        }
        if(getMovieTypeDTO.getRuntimeType()==1) {
            sql += flag?" and":" where";
            flag = true;
            sql += " runtime>="+getMovieDTO.getRuntime();
        }
        else if(getMovieTypeDTO.getRuntimeType()==2) {
            sql += flag?" and":" where";
            flag = true;
            sql += " runtime="+getMovieDTO.getRuntime();
        }
        else if(getMovieTypeDTO.getRuntimeType()==3) {
            sql += flag?" and":" where";
            flag = true;
            sql += " runtime<="+getMovieDTO.getRuntime();
        }
        if(getMovieTypeDTO.getReleaseYearType()==1) {
            sql += flag?" and":" where";
            flag = true;
            sql += " release_year>="+getMovieDTO.getReleaseYear();
        }
        else if(getMovieTypeDTO.getReleaseYearType()==2) {
            sql += flag?" and":" where";
            flag = true;
            sql += " release_year="+getMovieDTO.getReleaseYear();
        }
        else if(getMovieTypeDTO.getReleaseYearType()==3) {
            sql += flag?" and":" where";
            flag = true;
            sql += " release_year<="+getMovieDTO.getReleaseYear();
        }
        if(getMovieTypeDTO.getReleaseMonthType()==1) {
            sql += flag?" and":" where";
            flag = true;
            sql += " release_month>="+getMovieDTO.getReleaseMonth();
        }
        else if(getMovieTypeDTO.getReleaseMonthType()==2) {
            sql += flag?" and":" where";
            flag = true;
            sql += " release_month="+getMovieDTO.getReleaseMonth();
        }
        else if(getMovieTypeDTO.getReleaseMonthType()==3) {
            sql += flag?" and":" where";
            flag = true;
            sql += " release_month<="+getMovieDTO.getReleaseMonth();
        }
        if(getMovieTypeDTO.getReleaseDayType()==1) {
            sql += flag?" and":" where";
            flag = true;
            sql += " release_day>="+getMovieDTO.getReleaseDay();
        }
        else if(getMovieTypeDTO.getReleaseDayType()==2) {
            sql += flag?" and":" where";
            flag = true;
            sql += " release_day="+getMovieDTO.getReleaseDay();
        }
        else if(getMovieTypeDTO.getReleaseDayType()==3) {
            sql += flag?" and":" where";
            flag = true;
            sql += " release_day<="+getMovieDTO.getReleaseDay();
        }
        if(getMovieTypeDTO.getReleaseWeekdayType()==1) {
            sql += flag?" and":" where";
            flag = true;
            sql += " release_weekday>="+getMovieDTO.getReleaseWeekday();
        }
        else if(getMovieTypeDTO.getReleaseWeekdayType()==2) {
            sql += flag?" and":" where";
            flag = true;
            sql += " release_weekday="+getMovieDTO.getReleaseWeekday();
        }
        else if(getMovieTypeDTO.getReleaseWeekdayType()==3) {
            sql += flag?" and":" where";
            flag = true;
            sql += " release_weekday<="+getMovieDTO.getReleaseWeekday();
        }
        if(getMovieDTO.getLanguage()!=null) {
            sql += flag?" and":" where";
            flag = true;
            sql += " languageof.language regexp('.*"+getMovieDTO.getLanguage()+".*')";
        }
        if(getMovieDTO.getGenre()!=null) {
            sql += flag?" and":" where";
            flag = true;
            sql += " classify.genre regexp('.*"+getMovieDTO.getGenre()+".*')";
        }
        if(getMovieDTO.getFormat()!=null) {
            sql += flag?" and":" where";
            flag = true;
            sql += " binding regexp('.*"+getMovieDTO.getFormat()+".*')";
        }
        if(getMovieDTO.getDirector()!=null) {
            sql += flag?" and":" where";
            flag = true;
            sql += " direct.director regexp('.*"+getMovieDTO.getDirector()+".*')";
        }
        if(getMovieDTO.getActor()!=null) {
            sql += flag?" and":" where";
            flag = true;
            sql += " act.actor regexp('.*"+getMovieDTO.getActor()+".*')";
        }
        jdbcTemplate.execute(sql);
//        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        MoviesCountResult mcr = new MoviesCountResult();
//        Map<String, Object> mp = list.get(0);
//        int cur = 0;
//        for(Object value: mp.values()) {
//            if(cur==0)
//                mcr.setProductCount(Integer.parseInt(value.toString()));
//            else
//                mcr.setMovieCount(Integer.parseInt(value.toString()));
//            cur++;
//        }
//        mcr.setProductCount(list.size());
//        HashSet<String> hs = new HashSet<String>();
//        for(Map<String, Object> mp: list)
//            hs.add((String)mp.get("title"));
//        mcr.setMovieCount(hs.size());
        return mcr;
    }

}
