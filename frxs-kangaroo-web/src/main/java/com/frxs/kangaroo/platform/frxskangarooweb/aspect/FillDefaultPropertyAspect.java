package com.frxs.kangaroo.platform.frxskangarooweb.aspect;

import com.frxs.kangaroo.platform.frxskangaroo.common.base.BaseDto;
import com.frxs.kangaroo.platform.frxskangaroo.common.generator.CodeOrIdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;


/**
 *
 * @author xzq
 * @version $Id: AddRouteTagAspect.java,v 0.1 2020年11月30日 11:04 $Exp
 */
@Aspect
@Component
@Slf4j
public class FillDefaultPropertyAspect {

	public FillDefaultPropertyAspect() {
	}
	@Pointcut("execution(public * com.frxs.kangaroo.platform.frxskangaroo.service.core.service.impl..*(..))")
	public void fillDefaultProperty() {
	}

	@Around("fillDefaultProperty()")
	public Object doFillDefaultProperty(ProceedingJoinPoint joinPoint) throws Throwable {
		try {
			Object[] args = joinPoint.getArgs();
			for (Object arg:args) {
				if(arg instanceof BaseDto){
					BaseDto paramDto = (BaseDto) arg;
					paramDto.setId(UUID.randomUUID().toString());
					paramDto.setCreateUserId(CodeOrIdGenerator.DATE_TIME_ID.generateId());
					paramDto.setCreateUserName(CodeOrIdGenerator.DATE_TIME_ID.generateId()+"");
					paramDto.setModifyUserId(CodeOrIdGenerator.DATE_TIME_ID.generateId());
					paramDto.setModifyUserName(CodeOrIdGenerator.SHIFT_ID.generateId()+"");
					paramDto.setTmCreate(new Date());
					paramDto.setTmSmp(new Date());
				}
			}
			return joinPoint.proceed();
		} catch (Exception e) {
			log.error("FillDefaultPropertyAspect excute fail:{}", e);
			throw new RuntimeException(e);
		}
	}


}
