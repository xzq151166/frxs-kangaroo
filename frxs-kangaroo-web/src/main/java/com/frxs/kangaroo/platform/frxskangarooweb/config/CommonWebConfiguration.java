/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.kangaroo.platform.frxskangarooweb.config;

import com.frxs.kangaroo.platform.frxskangarooweb.interceptor.CommonResultHandleInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author xzq
 * @version $Id: CommonWebConfiguration.java,v 0.1 2020年12月27日 17:28 $Exp
 */
@Configuration
public class CommonWebConfiguration  extends WebMvcConfigurationSupport {
	@Resource
	private CommonResultHandleInterceptor commonResultHandleInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(commonResultHandleInterceptor);
		super.addInterceptors(registry);
	}

	/**
	 * 处理字符串会报错的问题
	 * @param converters
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(0, new MappingJackson2HttpMessageConverter());
	}
}