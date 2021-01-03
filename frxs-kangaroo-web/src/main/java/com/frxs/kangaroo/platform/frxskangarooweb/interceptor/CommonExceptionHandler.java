/*
 * frxs Inc.  湖南兴盛优选电子商务有限公司.
 * Copyright (c) 2017-2019. All Rights Reserved.
 */
package com.frxs.kangaroo.platform.frxskangarooweb.interceptor;

import com.frxs.kangaroo.platform.frxskangaroo.common.wrapper.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author xzq
 * @version $Id: CommonExceptionHandler.java,v 0.1 2020年12月27日 19:04 $Exp
 */
@RestControllerAdvice
@Slf4j
public class CommonExceptionHandler {
	@ExceptionHandler
	@ResponseBody
	public Response errorHandler( Exception e) {
		log.error("接口异常：",e);
		return Response.fail("500",e.getMessage());
	}
}