package com.bao.learnSpringBoot.Exception;

/**
 *这是枚举  统一维护 错误处理代码 和提示消息
 */
public enum  ExceptionEnums {
    // 在这个分号上面 定义所有的处理信息类型
    UNKONW_ERROR(-1,"未知错误"), //注意 这里是逗号分隔
    SUCCESS(200,"成功"),
    XIAO_QI(500,"小气鬼"),
    HAIBUCUO(501,"好不错，大气")
    ;

    //处理代码
    private Integer code;
    //处理消息
    private String msg;

    //给出构造方法  此时上面会对出一个分号;
    ExceptionEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    //给get方法
    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}