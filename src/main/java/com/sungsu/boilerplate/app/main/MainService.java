package com.sungsu.boilerplate.app.main;

import org.springframework.stereotype.Service;

import com.sungsu.boilerplate.app.main.aspect.ReturnDummy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MainService {

	@ReturnDummy(data = "test")
	public String method1() {
		log.info("method1");
		return "method1";
	}

	@ReturnDummy
	public String method2() {
		log.info("method2");
		return "method2";
	}

	@ReturnDummy
	public String method3() {
		log.info("method3");
		return "method3";
	}
}
