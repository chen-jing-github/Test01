package demo.springboot.dubbo.service.impl;

import demo.springboot.dubbo.service.DemoTest2Service;

public class DemoTest2ServiceImpl implements DemoTest2Service {

	public String serviceMethod1(String msg) {
		return "demo.springboot.dubbo.service.impl.DemoTest2ServiceImpl.serviceMethod1.msg=" + msg;
	}
}
