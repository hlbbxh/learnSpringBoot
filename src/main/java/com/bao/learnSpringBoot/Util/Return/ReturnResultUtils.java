package com.bao.learnSpringBoot.Util.Return;

import org.springframework.stereotype.Component;

/**
 * 
 *
 * @author hlb
 * 每次要返回 自定义的 返回数据类型  有返回错误 的   有 返回正确的 
 * 每次写 很麻烦  所有  定义了返回正确的 和返回错误 静态方法  方便调用
 */
@Component
public class ReturnResultUtils {
    /**
     * 成功的方法
     * @param object
     * @return
     */
    public static ReturnResult success(Object object){
        ReturnResult returnResult = new ReturnResult();
        returnResult.setCode(200);
        returnResult.setMsg("success");
        returnResult.setDate(object);
        return returnResult;
    }

    /**
     * 失败的方法
     * @param errercode
     * @param msg
     * @return
     */
    public static ReturnResult fild(Integer errercode,String msg){
        ReturnResult returnResult = new ReturnResult();
        returnResult.setCode(errercode);
        returnResult.setMsg(msg);
        returnResult.setDate(null);
        return returnResult;
    }
}
