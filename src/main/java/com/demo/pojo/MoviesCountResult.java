package com.demo.pojo;

import lombok.Data;

import java.util.List;

@Data
public class MoviesResult {
    private int productCount;
    private int movieCount;
    private List<String> list;
}
