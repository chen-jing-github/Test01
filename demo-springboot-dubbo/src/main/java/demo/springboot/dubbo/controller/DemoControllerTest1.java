package demo.springboot.dubbo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Vector;

import javax.annotation.Resource;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.gugusong.sqlmapper.springboot.PageData;
import com.sun.istack.internal.NotNull;

import demo.springboot.dubbo.common.exception.CustomException;
import demo.springboot.dubbo.entity.dto.BookDto;
import demo.springboot.dubbo.entity.dto.PageDto;
import demo.springboot.dubbo.entity.vo.BookVo;
import demo.springboot.dubbo.perm.entity.dto.RoleDto;
import demo.springboot.dubbo.perm.entity.dto.UserRoleDto;
import demo.springboot.dubbo.perm.entity.vo.RoleVo;
import demo.springboot.dubbo.perm.entity.vo.UserRoleVo;
import demo.springboot.dubbo.perm.service.RoleService;
import demo.springboot.dubbo.perm.service.UserRoleService;
import demo.springboot.dubbo.service.DemoTest1Service;
import redis.clients.jedis.Jedis;

@RestController
@RequestMapping(value = "/demoTest1")
public class DemoControllerTest1 {

	@Resource
	private DemoTest1Service demoTest1Service;
    @Reference(version = "${demo.service.version}")
//    @NacosInjected
    private RoleService roleService;
    @Reference(version = "${demo.service.version}")
	private UserRoleService userRoleService;

	@RequestMapping(value = "/method1")
	public String method1(String msg, Jedis jedis, ArrayList<String> arr, LinkedList<String> link
			, HashSet<String> hset) {
		Vector<String> vector = null;
		Collections.synchronizedList(new LinkedList());
		System.out.println("demo.springboot.dubbo.controller.DemoControllerTest1.method1.msg=" + msg);
		return msg;
	}

	@RequestMapping(value = "/addOneBook")
	public BookVo addOneBook(BookDto bookDto) {
		long randNumber = (new Date()).getTime();
		if (bookDto.getBookName() == null || "".contentEquals(bookDto.getBookName())) {
			bookDto = new BookDto();
			bookDto.setBookName("书本" + randNumber);
			bookDto.setLastUpdateTime(new Date());
			bookDto.setNumber(14245L);
			bookDto.setPrice(12.5F);
			bookDto.setNoStr("10" + randNumber);
			bookDto.setDetail("detail详情。。。" + randNumber);
			bookDto.setImgUrl("http://172.16.0.1:8080/book" + randNumber + ".jpg");
		}
		System.out.println("入参：" + bookDto.toString());
		BookVo bookVo = null;
//		BookVo bookVo = demoTest1Service.addOneBook(bookDto);
		try {
			bookVo = demoTest1Service.addOneBookTestTran(bookDto);
		} catch (CustomException e) {
			// TODO: handle exception
			bookVo = new BookVo();
			bookVo.setBookName("自定义异常：" + e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
			bookVo = new BookVo();
			bookVo.setBookName("大异常：" + e.getMessage());
		}
		return bookVo;
	}

	@RequestMapping(value = "/queryById")
	public BookVo queryById(@NotNull Integer id) {
		BookVo bookVo = demoTest1Service.queryById(id);
		System.out.println("--------查询书本：");
		System.out.println(JSONObject.toJSONString(bookVo));
		return bookVo;
	}

	@RequestMapping(value = "/queryBookList")
	public PageData<BookVo> queryBookList(BookDto queryBookDto, PageDto pageDto) {
		PageData<BookVo> pageData = demoTest1Service.queryBookList(queryBookDto, pageDto);
		System.out.println("--------查询书本列表：");
		System.out.println(JSONObject.toJSONString(pageData));
		return pageData;
	}

	@RequestMapping(value = "/role/add")
	public RoleVo addRole(RoleDto roleDto) {
		RoleVo roleVo = roleService.addOneRole(roleDto);
		return roleVo;
	}

	@RequestMapping(value = "/role/{id}")
	public RoleVo queryRoleById(@PathVariable("id") Integer id) {
		RoleVo roleVo = roleService.queryById(id);
		return roleVo;
	}

	@RequestMapping(value = "/role/page")
	public PageData<RoleVo> queryRoleList(RoleDto roleDto, PageDto pageDto) {
		PageData<RoleVo> pageData = roleService.queryRoleList(roleDto, pageDto);
		return pageData;
	}

	@RequestMapping(value = "/userRole/add")
	public UserRoleVo addUserRole(UserRoleDto userRoleDto) {
		UserRoleVo userRoleVo = userRoleService.addOneUserRole(userRoleDto);
		return userRoleVo;
	}

	@RequestMapping(value = "/userRole/{id}")
	public UserRoleVo queryUserRoleById(@PathVariable("id") Integer id) {
		UserRoleVo userRoleVo = userRoleService.queryById(id);
		return userRoleVo;
	}

	@RequestMapping(value = "/userRole/page")
	public PageData<UserRoleVo> queryUserRoleList(UserRoleDto userRoleDto, PageDto pageDto) {
		PageData<UserRoleVo> pageData = userRoleService.queryUserRoleList(userRoleDto, pageDto);
		return pageData;
	}
	
}
