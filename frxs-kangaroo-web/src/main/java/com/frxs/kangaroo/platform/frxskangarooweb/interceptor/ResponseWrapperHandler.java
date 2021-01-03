/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.kangaroo.platform.frxskangarooweb.interceptor;

import com.frxs.kangaroo.platform.frxskangaroo.common.Enum.WrapperType;
import com.frxs.kangaroo.platform.frxskangaroo.common.wrapper.Response;
import com.frxs.kangaroo.platform.frxskangaroo.common.wrapper.annotation.ResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author xzq
 * @version $Id: ResponseWrapperHandler.java,v 0.1 2020年12月27日 17:20 $Exp
 */
@Slf4j
@ControllerAdvice
public class ResponseWrapperHandler implements ResponseBodyAdvice {
	@Override
	public boolean supports(MethodParameter methodParameter, Class aClass) {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		ResponseWrapper wrapper = (ResponseWrapper) request.getAttribute(WrapperType.NEED_WRAPPER.getCode());
		return wrapper == null ? Boolean.FALSE : Boolean.TRUE;
	}

	@Override
	public Object beforeBodyWrite(Object result, MethodParameter methodParameter, MediaType mediaType, Class aClass,
			ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

		if (result instanceof Response) {
			return result;
		}
		//统一包装
		return Response.ok(result);
	}
}