package com.demo.controller;

import com.demo.dto.GetMovieDTO;
import com.demo.pojo.JsonResult;
import com.demo.service.HiveMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiveMovieController {

//    @Autowired
//    private HiveMovieService hiveMovieService;

//    @RequestMapping("/hive")
//    public List<Map<String, Object>> test() throws Exception {
//        String sql = "select * from uuser";
//        List<Map<String, Object>> list = hiveJdbcTemplate.queryForList(sql);
////        return list.get(0);
//        return list;
//    }

//    @RequestMapping("/hiveMovieCount")
//    public void getMovieCount() {
//
//        GetMovieDTO getMovieDTO = new GetMovieDTO();
//        getMovieDTO.setTitle("Harry");
//
////        return hiveMovieService.getMovieCount(getMovieDTO);
//    }


}
