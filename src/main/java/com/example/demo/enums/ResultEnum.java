package com.example.demo.enums;

/**
 * 将code和message对应起来
 * Created by xzf on 2017/9/19.
 */
public enum ResultEnum {
    UNKNOW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"你可能在上小学"),
    MIDDLE_SCHOOL(101,"你可能在上初中"),
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 枚举类中给getter方法就可以了，枚举的使用都是使用构造方法来创建，不会再set它的值
     * @return
     */
    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
