package com.demo.pojo.neo4j.ReturnDTO;


import lombok.Data;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity
@Data
public class MovieTitle {
    @Property(name = "title")
    private String title;
}
