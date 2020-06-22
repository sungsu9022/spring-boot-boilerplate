package com.sungsu.boilerplate.app.main;

import org.springframework.stereotype.Service;

import com.sungsu.boilerplate.app.main.aspect.ReturnDummy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MainService {

	@ReturnDummy
	public String method1() {
		log.info("method1");
		return "method1";
	}
}
