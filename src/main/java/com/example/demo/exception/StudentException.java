package com.example.demo.exception;

import com.example.demo.enums.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.plugin2.message.Message;

/**
 * Created by xzf on 2017/9/19.
 */
//Spring框架只对RuntimeException抛出的异常进行回滚，因此此处不用Exception
public class StudentException extends RuntimeException{

    private Integer code;

    public StudentException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());//父类构造方法中本身会传一个message进去
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
