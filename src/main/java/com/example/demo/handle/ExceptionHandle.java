package com.example.demo.handle;

import com.example.demo.domain.Result;
import com.example.demo.exception.StudentException;
import com.example.demo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xzf on 2017/9/19.
 */
@ControllerAdvice
public class ExceptionHandle {

    private static final Logger logger= LoggerFactory.getLogger(StudentException.class);

    @ExceptionHandler(value = Exception.class)  //声明捕获的异常类
    @ResponseBody       //返回的是json数据，然而类前使用的不是@RestController注解，因此需要加上@ResponseBody
    public Result handle(Exception e){
        if (e instanceof StudentException){
            StudentException exception=(StudentException) e;
            return ResultUtil.error(exception.getCode(),exception.getMessage());
        }
        logger.error("【系统异常】",e);//控制台输出异常信息
        return ResultUtil.error(-1,"未知错误！");//返回json信息
    }

}
