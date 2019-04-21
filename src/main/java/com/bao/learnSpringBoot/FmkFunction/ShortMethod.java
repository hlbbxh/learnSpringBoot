package com.bao.learnSpringBoot.FmkFunction;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import freemarker.template.SimpleSequence;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
/**
 * @author Gelil
 *  fmk 模板自定义排序函数
 */
public class ShortMethod implements TemplateMethodModelEx{//实现这个接口    要实里面的方法

	
	
	@Override
	public Object exec(List lisy) throws TemplateModelException {
		SimpleSequence sequence =(SimpleSequence) lisy.get(0);//获取到参数  传过来的参数  fmk定义自己的数据类型
		//SimpleSequence代表的 fmk的数组 
		List<BigDecimal> javalist = sequence.toList(); //转换为java的list
		
		//进行排序
		Collections.sort(javalist,new Comparator<BigDecimal>() {//new Comparator 实现里面的方法
			@Override
			public int compare(BigDecimal o1, BigDecimal o2) {
				// TODO Auto-generated method stub  
				return o1.intValue()-o2.intValue();//进行升序的操作 
			}
		});
		
		return javalist; //直接返回排序好的list
	}
	
}
