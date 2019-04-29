package com.bao.learnSpringBoot.Exception;
/**
 * expection 只能传一个 message  所以我们要定义自己的异常
 * @author hlb
 *
 */
public class MyselfExpception extends RuntimeException{ // 要继承 RuntimeException 事物才会回滚！！！
	
    private Integer code; //处理结果代码
    
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 之前的构造方法
     * @param code
     * @param msg
     */
    public MyselfExpception(Integer code,String msg){
        super(msg);//父类的构造方法 本身就要一个msg
        this.code = code;//当前的处理代码
    }
    
    /**
     * 使用枚举管理 处理信息的 构造方法
     * @param exceptionEnums
     */
    public MyselfExpception(ExceptionEnums exceptionEnums){
        super(exceptionEnums.getMsg()); //从枚举获取 信息
        this.code=exceptionEnums.getCode();//获取从 枚举中拿
    }
}
