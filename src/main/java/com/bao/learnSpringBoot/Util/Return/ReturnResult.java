package com.bao.learnSpringBoot.Util.Return;

import org.springframework.stereotype.Component;

/**
 * 
 * @author hyd
 * 统一返回信息 
 * 可以自定义嘛  但是每次 成功 返回 一个 失败  又返回一个 所有诞生了 ReturnResultUtils
 * @param <T>
 */
@Component
public class ReturnResult<T> {	
		//处理代码
		private Integer code;
		//处理结果提示
		private String msg;
		//处理数据
		private T date;
		
		//get set
		public Integer getCode() {
			return code;
		}
		public void setCode(Integer code) {
			this.code = code;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		public T getDate() {
			return date;
		}
		public void setDate(T date) {
			this.date = date;
		}
}
