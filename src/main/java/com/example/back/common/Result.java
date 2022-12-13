package com.example.back.common;

import lombok.Data;

@Data
public class Result {
    private int code;//编码 200成功 400失败
    private String msg;//信息 成功 失败
    private Long total;//总记录数
    private Object data;//数据

    private static Result result(int code,String msg,Long total,Object data){
        Result res = new Result();
        res.setCode(code);
        res.setMsg(msg);
        res.setTotal(total);
        res.setData(data);
        return res;
    }

    public static Result error(){
        return result(400,"失败",0L,null);
    }

    public static Result error(String msg){
        return result(400,msg,0L,null);
    }

    public static Result success(){
        return result(200,"成功",0L,null);
    }

    public static Result success(Object data){
        return result(200,"成功",0L,data);
    }

    public static Result success(Long total,Object data){
        return result(200,"成功",total,data);
    }
}
