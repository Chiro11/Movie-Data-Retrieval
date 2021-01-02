package com.demo.controller;

import com.demo.dto.GetMovieDTO;
import com.demo.dto.GetMovieTypeDTO;
import com.demo.pojo.JsonResult;
import com.demo.pojo.MoviesCountResult;
import com.demo.service.HiveMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hive")
public class HiveMovieController {

    @Autowired
    private HiveMovieService hiveMovieService;

//    @RequestMapping("/hive")
//    public List<Map<String, Object>> test() throws Exception {
//        String sql = "select * from uuser";
//        List<Map<String, Object>> list = hiveJdbcTemplate.queryForList(sql);
////        return list.get(0);
//        return list;
//    }

    @Autowired
    @Qualifier("hiveJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/hello")
    public String index() {
        return "hello";
    }

    @RequestMapping("/test")
    public JsonResult test(GetMovieDTO getMovieDTO, GetMovieTypeDTO getMovieTypeDTO) {
        long startTime = System.currentTimeMillis();
        getMovieDTO.setLanguage("English");
        MoviesCountResult mcr = hiveMovieService.test(getMovieDTO, getMovieTypeDTO, jdbcTemplate);
        long endTime = System.currentTimeMillis();
        return new JsonResult("ok", endTime-startTime, mcr);
    }

    @RequestMapping("/getMoviesCount")
    public JsonResult getMoviesCount(GetMovieDTO getMovieDTO, GetMovieTypeDTO getMovieTypeDTO) {
        long startTime = System.currentTimeMillis();
//        getMovieDTO.setReleaseYear(2000);
//        getMovieTypeDTO.setReleaseYearType(2);
        getMovieDTO.setDirector("Harry");
        getMovieDTO.setLanguage("english");
        getMovieDTO.setReleaseYear(2000);
        getMovieTypeDTO.setReleaseYearType(2);
//        getMovieDTO.setLanguage("english");
        MoviesCountResult mcr = hiveMovieService.getMoviesCount(getMovieDTO, getMovieTypeDTO, jdbcTemplate);
        long endTime = System.currentTimeMillis();
        return new JsonResult("ok", endTime-startTime, mcr);
    }
}
