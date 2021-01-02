package com.demo.pojo.neo4j.ReturnDTO;


import lombok.Data;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity
@Data
public class Product {

    @Property(name = "title")
    private String title;

    @Property(name = "language")
    private String language;

    @Property(name = "binding")
    private String binding;

    @Property(name = "rate")
    private String rate;

    @Property(name = "runtime")
    private String runtime;

    @Property(name = "year")
    private String year;

    @Property(name = "month")
    private String month;

    @Property(name = "day")
    private String day;

    @Property(name = "week")
    private String week;

    @Property(name = "productId")
    private String productId;

}
