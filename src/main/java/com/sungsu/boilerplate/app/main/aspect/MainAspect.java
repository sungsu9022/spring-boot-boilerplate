package com.sungsu.boilerplate.app.main.aspect;

import java.util.stream.Collectors;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.sungsu.boilerplate.config.env.EnvConfig;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class MainAspect {
	private final EnvConfig envConfig;

	@Around("execution(String com.sungsu.boilerplate.app.main.MainService.*(..)) && @annotation(com.sungsu.boilerplate.app.main.aspect.ReturnDummy)")
	public Object returnDummy(ProceedingJoinPoint joinPoint) throws Throwable {
		if (!isLocalEnvironment()) {
			return joinPoint.proceed();
		}

		log.info("returnDummy");
		return "returnDummy";
	}
	
	/**
	 * 수행 여부 체크
	 * @return
	 * @throws Throwable
	 */
	private boolean isLocalEnvironment() throws Throwable {
		return envConfig.isLocal();
	}


}
