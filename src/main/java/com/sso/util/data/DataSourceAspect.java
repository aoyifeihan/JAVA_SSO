package com.sso.util.data;

import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class DataSourceAspect {
	private String defaultDataSource;

	public String getDefaultDataSource() {
		return defaultDataSource;
	}

	public void setDefaultDataSource(String defaultDataSource) {
		this.defaultDataSource = defaultDataSource;
	}

	// @Pointcut("execution(* com.apc.cms.service.*.*(..))")
	public void pointCut() {
	}

	// @Before(value = "pointCut()")
	public void before(JoinPoint point) throws NoSuchMethodException, SecurityException {
		Object target = point.getTarget();
		System.out.println(target.toString());
		Class<?> clazz = target.getClass();
		if (clazz != null && clazz.isAnnotationPresent(DataSource.class)) {
			DataSource dataClass = clazz.getAnnotation(DataSource.class);
			CustomerContextHolder.setCustomerType(dataClass.value());
			return;
		}
		Class<?>[] interF = target.getClass().getInterfaces();
		if (interF != null && interF[0].isAnnotationPresent(DataSource.class)) {
			DataSource dataClass = interF[0].getAnnotation(DataSource.class);
			CustomerContextHolder.setCustomerType(dataClass.value());
			return;
		}
		String method = point.getSignature().getName();
		System.out.println(method);
		Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
		Method m = null;
		if (clazz != null) {
			Method mClazz = clazz.getMethod(method, parameterTypes);
			if (mClazz != null && mClazz.isAnnotationPresent(DataSource.class)) {
				m = mClazz;
			}
		}
		if (m == null) {
			if (interF != null) {
				Method minterF = interF[0].getMethod(method, parameterTypes);
				if (minterF != null && minterF.isAnnotationPresent(DataSource.class)) {
					m = minterF;
				}
			}
		}
		if (m != null && m.isAnnotationPresent(DataSource.class)) {
			DataSource dataClass = m.getAnnotation(DataSource.class);
			CustomerContextHolder.setCustomerType(dataClass.value());
			return;
		}

	}

	public void after(JoinPoint point) {
		CustomerContextHolder.clearCustomerType();
	}
}