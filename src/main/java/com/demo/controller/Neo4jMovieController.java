package com.demo.controller;


import com.demo.pojo.JsonResult;
import com.demo.pojo.MoviesCountResult;
import com.demo.pojo.neo4j.GetDTO.Command;
import com.demo.pojo.neo4j.GetDTO.GetCooperationDTO;
import com.demo.pojo.neo4j.GetDTO.GetSeriesMovieDTO;
import com.demo.pojo.neo4j.GetDTO.GetStatisticDTO;
import com.demo.pojo.neo4j.ReturnDTO.MovieTitle;
import com.demo.pojo.neo4j.ReturnDTO.Product;
import com.demo.service.Neo4jMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/neo4j")
public class Neo4jMovieController {

    @Autowired
    Neo4jMovieService neo4jMovieService;


    @RequestMapping("/getTenProduct")
    public JsonResult getTenProduct(){
        //return new JsonResult("ok",0,10);
        return new JsonResult("ok",0,neo4jMovieService.getTenProduct());
    }

    @RequestMapping("/getProductByTime")
    public JsonResult getProductByTime(){
        List<Command> commands=new ArrayList<>();
        commands.add(new Command("year","equal","2009"));
        commands.add(new Command("day","equal","2"));

        return new JsonResult("ok",0,neo4jMovieService.getByTime(commands));
    }



    @PostMapping("/getMovieByCondition")
    public JsonResult getMovieByCondition(@RequestBody List<Command> commands){
//        List<Command> commands=new ArrayList<>();
//        commands.add(new Command("year","equal","2009"));
//        commands.add(new Command("day","equal","2"));
        long startTime = System.currentTimeMillis();
        var list=neo4jMovieService.getMovieByCondition(commands);
        long endTime = System.currentTimeMillis();
        return new JsonResult("ok",endTime-startTime,list);
    }


    @PostMapping("/getMovieNumByCondition")
    public JsonResult getMovieNumByCondition(@RequestBody List<Command> commands){
//        List<Command> commands=new ArrayList<>();
//        commands.add(new Command("year","equal","2009"));
//        commands.add(new Command("day","equal","2"));
        long startTime = System.currentTimeMillis();
        var list=neo4jMovieService.getMovieNumByCondition(commands);
        long endTime = System.currentTimeMillis();

        return new JsonResult("ok",endTime-startTime,list);
    }


    //参数为
    @PostMapping("/getCooperation")
    public JsonResult getCooperation(@RequestBody GetCooperationDTO dto){
//        GetCooperationDTO dto=new GetCooperationDTO();
//        dto.setRole1("actor");
//        dto.setRole2("actor");
//        dto.setName("Animat");

        long startTime = System.currentTimeMillis();
        var list=neo4jMovieService.getCooperation(dto);
        long endTime = System.currentTimeMillis();
        return new JsonResult("ok",endTime-startTime,list);
    }

    @PostMapping("/getTopCooperation")
    public JsonResult getTopCooperation(@RequestBody GetCooperationDTO dto){
//        GetCooperationDTO dto=new GetCooperationDTO();
//        dto.setRole1("actor");
//        dto.setRole2("actor");
        long startTime = System.currentTimeMillis();
        var list=neo4jMovieService.getTopCooperation(dto);
        long endTime = System.currentTimeMillis();
        return new JsonResult("ok",endTime-startTime,list);

    }

    @PostMapping("/getStatistic")
    public JsonResult getStatistic(@RequestBody GetStatisticDTO getStasticDTO){
//        GetStatisticDTO getStasticDTO=new GetStatisticDTO();
//        getStasticDTO.setField("genre");

        long startTime = System.currentTimeMillis();
        var list=neo4jMovieService.getStatistic(getStasticDTO);
        long endTime = System.currentTimeMillis();
        return new JsonResult("ok",endTime-startTime,list);
    }


    @PostMapping("/getSeriesMovie")
    public JsonResult getSeriesMovie(@RequestBody GetSeriesMovieDTO getSeriesMovieDTO){
//        GetSeriesMovieDTO getSeriesMovieDTO=new GetSeriesMovieDTO();
//        getSeriesMovieDTO.setTitle("Harry Potter And The Deathly Hallows Part 2");
        long startTime = System.currentTimeMillis();
        var list=neo4jMovieService.getSeriesMovie(getSeriesMovieDTO);
        long endTime = System.currentTimeMillis();

        return new JsonResult("ok",endTime-startTime,list);
    }

    @RequestMapping("/getProductMovie")
    public JsonResult getProductMovie(@RequestBody GetSeriesMovieDTO getSeriesMovieDTO){
//        GetSeriesMovieDTO getSeriesMovieDTO=new GetSeriesMovieDTO();
//        getSeriesMovieDTO.setTitle("Harry Potter And The Deathly Hallows Part 2");
        long startTime = System.currentTimeMillis();
        var list=neo4jMovieService.getProductMovie(getSeriesMovieDTO);
        long endTime = System.currentTimeMillis();

        return new JsonResult("ok",endTime-startTime,list);
    }
}
