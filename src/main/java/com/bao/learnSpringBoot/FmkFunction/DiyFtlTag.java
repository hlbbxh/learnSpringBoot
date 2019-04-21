package com.bao.learnSpringBoot.FmkFunction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import freemarker.core.Environment;
import freemarker.template.SimpleSequence;
import freemarker.template.TemplateBooleanModel;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateScalarModel;

/**
 * @author Gelil
 * 标签处理的具体类
 */
@Component
public class DiyFtlTag implements TemplateDirectiveModel{ // 实现 implements 接口的方法 execute
	//在freemarker中实现自定义的标签，主要就是靠TemplateDirectiveModel类。如字面意思：模板指令模型，主要就是用来扩展自定义的指令(和freemarker的宏类似，自定义标签也属于这个范畴)
	
	/**
	 * env :环境变量
	 * params ： 入参  就是页面的 key value 的形式  <@role user='132456' role='admin';
	 * loopVars 返回值   数组 用逗号间隔    注意 这个接口的实现类    不可以用java的类型 
	 * body 输出内容
	 * 
	 */
	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
			throws TemplateException, IOException {
		TemplateScalarModel user = (TemplateScalarModel) params.get("user");//获得user 值 转换为fmk的数据类型
		TemplateScalarModel role = (TemplateScalarModel) params.get("role"); // 获得权限
		
		if("123456".equals(user.getAsString()) && "admin".equals(role.getAsString())) {//验证id
			loopVars[0]=TemplateBooleanModel.TRUE;//返回true
		}
		
		List<String> otherRights = new ArrayList<String>();//权限
		otherRights.add("add");
		otherRights.add("del");
		otherRights.add("update");
		otherRights.add("select");
		loopVars[1]=new SimpleSequence(otherRights); // new SimpleSequence 权限放入第二个出参数
		
		body.render(env.getOut()); //输出
	}
	
}