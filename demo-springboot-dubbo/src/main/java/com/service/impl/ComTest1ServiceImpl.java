package com.service.impl;

import org.apache.dubbo.config.annotation.Service;

import com.service.ComTest1Service;

@Service(version = "${demo.service.version}", interfaceClass = ComTest1Service.class)
public class ComTest1ServiceImpl implements ComTest1Service {

	public String serviceMethod1(String msg) {
		return "com.service.impl.ComTest1ServiceImpl.serviceMethod1.msg=" + msg;
	}
}
