package com.demo.pojo.neo4j.GetDTO;

import lombok.Data;

import java.io.Serializable;


@Data
public class Command{

    /*
    * year,month,day,week,title,
    * actor,director,genre,runtime,binding,language
    * */
    private String field;
    //equal,less,greater,contain
    private String condition;

    private String value;

    public Command(){}
    public Command(String field,String condition,String value){
        this.condition=condition;
        this.field=field;
        this.value=value;
    }

    //默认等于
    public Command(String field, String value){
        this.field=field;
        this.value=value;
    }

}
