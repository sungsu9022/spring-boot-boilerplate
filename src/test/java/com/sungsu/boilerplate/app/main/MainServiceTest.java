package com.sungsu.boilerplate.app.main;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import com.sungsu.boilerplate.app.main.aspect.MainAspect;
import com.sungsu.boilerplate.config.env.EnvConfig;

@RunWith(MockitoJUnitRunner.class)
public class MainServiceTest {

	@InjectMocks
	private MainService mainService;
	@InjectMocks
	private MainAspect aspect;
	@Mock
	private EnvConfig envConfig;


	@Before
	public void setUp() {
		AspectJProxyFactory factory = new AspectJProxyFactory(mainService);
		factory.addAspect(aspect);
		factory.setProxyTargetClass(true);
		mainService = factory.getProxy();
	}

	@Test
	public void method1() {
		Mockito.when(envConfig.isLocal()).thenReturn(true);
		assertTrue(MainAspect.DUMMY_VALUE.equals(mainService.method1()));
	}

}