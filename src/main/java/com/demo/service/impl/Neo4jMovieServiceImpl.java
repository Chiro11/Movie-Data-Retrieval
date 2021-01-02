package com.demo.service.impl;


import com.demo.mapper.neo4j.Neo4jMovieMapper;
import com.demo.pojo.neo4j.GetDTO.Command;
import com.demo.pojo.neo4j.GetDTO.GetCooperationDTO;
import com.demo.pojo.neo4j.GetDTO.GetSeriesMovieDTO;
import com.demo.pojo.neo4j.GetDTO.GetStatisticDTO;
import com.demo.pojo.neo4j.ReturnDTO.*;
import com.demo.service.Neo4jMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Neo4jMovieServiceImpl implements Neo4jMovieService {

    @Autowired
    Neo4jMovieMapper movieMapper;

    @Override
    public List<Product> getTenProduct() {
        return movieMapper.getTenProduct();
    }

    @Override
    public List<SimpleProduct> getByTime(List<Command> commands){
        return movieMapper.getByTime(commands);
    }

    @Override
    public  List<SimpleMovie> getMovieByCondition(List<Command>commands){
        List<SimpleMovie> list=movieMapper.getMovieByCondition(commands);
//        for(int i=0;i<list.size();i++){
//            String title=list.get(i).getTitle();
//            list.get(i).setActor(String.join(",",movieMapper.getMovieActor(title)));
//            list.get(i).setDirector(String.join(",",movieMapper.getMovieDirector(title)));
//            list.get(i).setGenre(String.join(",",movieMapper.getMovieGenre(title)));
//        }

        Collections.sort(list, new Comparator<SimpleMovie>() {
            @Override
            public int compare(SimpleMovie o1, SimpleMovie o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        int i=0;
        int tot=0;
        HashSet<String> genre=new HashSet<>();
        HashSet<String> actor=new HashSet<>();
        HashSet<String> director=new HashSet<>();
        while(i<list.size()){
            int s=i;
            while(i<list.size()&&list.get(i).getTitle().equals(list.get(s).getTitle())){
                genre.add(list.get(i).getGenre());
                actor.add(list.get(i).getActor());
                director.add((list.get(i).getDirector()));
                i+=1;
            }
            list.get(tot).setTitle(list.get(s).getTitle());
            list.get(tot).setGenre(String.join(",",genre));
            list.get(tot).setActor(String.join(",",actor));
            list.get(tot).setDirector(String.join(",",director));
            tot+=1;
        }

        return list.subList(0,tot);
    }

    @Override
    public MatchNum getMovieNumByCondition(List<Command> commands){
        return movieMapper.getMovieNumByCondition(commands);
    }

    @Override
    public List<ReturnCooperationDTO> getCooperation(GetCooperationDTO getCooperationDTO){
        return movieMapper.getCooperation(getCooperationDTO);
    }

    @Override
    public List<ReturnCooperationDTO> getTopCooperation(GetCooperationDTO getCooperationDTO){
        List<ReturnCooperationDTO> returnCooperationDTOS = movieMapper.getTopCooperation(getCooperationDTO);

        if (getCooperationDTO.getRole1().equals(getCooperationDTO.getRole2())) {
            List<ReturnCooperationDTO> ret=new ArrayList<>();
            for(int i=0;i<returnCooperationDTOS.size();i+=2){
                ret.add(returnCooperationDTOS.get(i));
            }
            return ret;
        }else{
            return returnCooperationDTOS;
        }


        //        Collections.sort(returnCooperationDTOS, new Comparator<ReturnCooperationDTO>() {
//            @Override
//            public int compare(ReturnCooperationDTO o1, ReturnCooperationDTO o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });
//        int len=returnCooperationDTOS.size();
//        int i=0;
//        int tot=0;
//        while(i<len){
//            int s=i;
//            while(i<len&&returnCooperationDTOS.get(i)== returnCooperationDTOS.get(s)){
//                i++;
//            }
//            returnCooperationDTOS.set(tot,returnCooperationDTOS.get(s));
//            returnCooperationDTOS.get(tot).setCount(i-s);
//            tot++;
//        }
//        Collections.sort(returnCooperationDTOS, new Comparator<ReturnCooperationDTO>() {
//            @Override
//            public int compare(ReturnCooperationDTO o1, ReturnCooperationDTO o2) {
//                return -o1.getCount()+o2.getCount();
//            }
//        });
//        return returnCooperationDTOS.subList(0,50);
    }


    @Override
    public List<Statistic> getStatistic(GetStatisticDTO getStasticDTO){
        return movieMapper.getStatistic(getStasticDTO);
    }

    @Override
    public List<MovieTitle> getSeriesMovie(GetSeriesMovieDTO getSeriesMovieDTO){
        return movieMapper.getSeriesMovie(getSeriesMovieDTO);
    }

    @Override
    public List<SimpleProduct> getProductMovie(GetSeriesMovieDTO getSeriesMovieDTO){
        return movieMapper.getProductMovie(getSeriesMovieDTO);
    }
}
