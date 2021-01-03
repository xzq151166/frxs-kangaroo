package com.frxs.kangaroo.platform.frxskangarooweb.interceptor;

import com.frxs.kangaroo.platform.frxskangaroo.common.Enum.WrapperType;
import com.frxs.kangaroo.platform.frxskangaroo.common.wrapper.annotation.ResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Slf4j
@Component
public class CommonResultHandleInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
		if (handler instanceof HandlerMethod) {
			final HandlerMethod handlerMethod = (HandlerMethod) handler;
			final Class<?> clazz = handlerMethod.getBeanType();
			final Method method = handlerMethod.getMethod();
			//标记
			if(clazz.isAnnotationPresent(ResponseWrapper.class)){
				request.setAttribute(WrapperType.NEED_WRAPPER.getCode(),clazz.getAnnotation(ResponseWrapper.class));
			}else if(method.isAnnotationPresent(ResponseWrapper.class)){
				request.setAttribute(WrapperType.NEED_WRAPPER.getCode(),method.getAnnotation(ResponseWrapper.class));
			}
		}
		return true;
	}
}
