package com.demo.mapper;

import com.demo.dto.GetMovieDTO;
import com.demo.pojo.ProductMoviePair;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@Mapper
public class HiveMovieMapper {

//    @Autowired
//    @Qualifier("hiveJdbcTemplate")
//    private JdbcTemplate jdbcTemplate;

//    public ProductMoviePair getMovieCount(GetMovieDTO getMovieDTO) {
//        return new ProductMoviePair(1, 1);
//    }

//    public ProductMoviePair getMovieCount(GetMovieDTO getMovieDTO) {
//        String sql = "select count(*), count(distinct title)";
//        sql += " from product";
//        if(getMovieDTO.getTitle() != null) {
//            sql += " where title="+getMovieDTO.getTitle();
//        }
//        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
//        Map<String, Object> mp = list.get(0);
//        int cnt = 0;
//        ProductMoviePair pmp = new ProductMoviePair();
//        for(Object value: mp.values()) {
//            if(cnt==1)
//                pmp.setMovieNum((Integer)value);
//            else
//                pmp.setProductNum((Integer)value);
//            cnt++;
//        }
//        return pmp;
//    }
}
