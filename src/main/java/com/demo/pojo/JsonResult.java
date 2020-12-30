package com.demo.pojo;

import lombok.Data;

@Data
public class JsonResult {

    private String msg;
    private long queryTime;
    private Object obj;

    public JsonResult(String msg, long queryTime, Object obj) {
        this.msg = msg;
        this.queryTime = queryTime;
        this.obj = obj;
    }
}
