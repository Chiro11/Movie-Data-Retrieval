package com.demo.pojo.neo4j.ReturnDTO;


import lombok.Data;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity
@Data
public class SimpleMovie {
    @Property(name = "title")
    private String title;

    @Property(name = "actor")
    private String actor;

    @Property(name = "director")
    private String director;

    @Property(name = "genre")
    private String genre;

}
