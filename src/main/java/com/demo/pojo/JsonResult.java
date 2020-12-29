package com.demo.pojo;

public class JsonResult {
    private String msg;
    private int queryTime;
    private Object obj;
    JsonResult(String msg, Object obj) {
        this.msg = msg;
        this.obj = obj;
    }
}
