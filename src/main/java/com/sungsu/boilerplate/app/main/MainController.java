package com.sungsu.boilerplate.app.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	private final MainService mainService;

	@GetMapping(value = {"/", "/main"})
	public String main() {
		mainService.method1();
		mainService.method2();
		mainService.method3();
		return "index";
	}
}
