package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComControllerTest1 {

	@RequestMapping(value = "/method1")
	public String method1(String msg) {
		System.out.println("com.controller.ComControllerTest1.method1.msg=" + msg);
		return msg;
	}

}
