package com.bao.learnSpringBoot.Config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.bao.learnSpringBoot.FmkFunction.DiyFtlTag;

import freemarker.template.TemplateModelException;

@Configuration 
public class FreeMarkerConfig {

	    @Autowired
	    protected freemarker.template.Configuration configuration;//fmk的自定义的标签
	    @Autowired
	    protected DiyFtlTag diyFtlTag;//自定义的标签处理类

	    /**
	     * 添加自定义标签
	     * @throws TemplateModelException 
	     */
	    @PostConstruct
	    public void setSharedVariable() throws TemplateModelException {//放入标签
			/*
			 * 向freemarker配置中添加共享变量;
			 * 它使用Configurable.getObjectWrapper()来包装值，因此在此之前设置对象包装器是很重要的。（即上一步的builder.build().wrap操作）
			 * 这种方法不是线程安全的;使用它的限制与那些修改设置值的限制相同。	
			 * 如果使用这种配置从多个线程运行模板，那么附加的值应该是线程安全的。
			 */
	        configuration.setSharedVariable("role", diyFtlTag);//标签对应的处理类
	    }
}
