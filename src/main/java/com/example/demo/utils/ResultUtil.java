package com.example.demo.utils;

import com.example.demo.domain.Result;

/**
 * Created by xzf on 2017/9/19.
 */
public class ResultUtil {
    public static Result success(Object object){
        Result result=new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    //成功的情况下也可能不含object（即成功也可能没有返回数据）
    public static Result success(){
        //此处调用上面定义的success方法，传入null值
        return success(null);
    }

    public static Result error(Integer code,String msg){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
