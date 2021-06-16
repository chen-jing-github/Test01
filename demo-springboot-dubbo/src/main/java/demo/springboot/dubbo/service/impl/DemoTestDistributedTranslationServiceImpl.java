package demo.springboot.dubbo.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.transaction.annotation.Transactional;

import com.gugusong.sqlmapper.springboot.SqlHelpBaseDao;

import demo.springboot.dubbo.entity.dto.BookDto;
import demo.springboot.dubbo.entity.pojo.Book;
import demo.springboot.dubbo.entity.pojo.BookDetail;
import demo.springboot.dubbo.entity.vo.BookVo;
import demo.springboot.dubbo.perm.entity.dto.RoleDto;
import demo.springboot.dubbo.perm.entity.dto.UserRoleDto;
import demo.springboot.dubbo.perm.entity.vo.RoleVo;
import demo.springboot.dubbo.perm.service.RoleService;
import demo.springboot.dubbo.perm.service.UserRoleService;

/**
 * demo测试分布式事务的serviceImpl
 *
 */
public class DemoTestDistributedTranslationServiceImpl {

	@Resource
	private SqlHelpBaseDao dao;
    @Reference(version = "${demo.service.version}")
	private RoleService roleService;
    @Reference(version = "${demo.service.version}")
	private UserRoleService userRoleService;

	@Transactional(rollbackFor = Exception.class)
	public BookVo addOneBookTestTran(BookDto bookDto) {
		Book book = this.covertBook(bookDto);
		book = dao.save(book);
		bookDto.setId(book.getId());
		BookDetail bookDetail = this.covertBookDetail(bookDto);
		bookDetail = dao.save(bookDetail);
		BookVo bookVo = dao.findOneByIdForUpdate(BookVo.class, book.getId());
		
		// 添加角色，正常
		RoleDto roleDto = new RoleDto();
		roleDto.setRoleName("角色" + new Date().getTime());
		RoleVo roleVo = roleService.addOneRole(roleDto);
		
		// 添加用户角色关系，异常		
		UserRoleDto userRoleDto = new UserRoleDto();
		userRoleDto.setRoleId(roleVo.getId());
		userRoleService.addOneUserRoleThrowEx(userRoleDto);
		return bookVo;
	}

	
	private Book covertBook(BookDto bookDto) {
		Book book = new Book();
		book.setBookName(bookDto.getBookName());
		book.setLastUpdateTime(bookDto.getLastUpdateTime());
		book.setNumber(bookDto.getNumber());
		book.setPrice(bookDto.getPrice());
		book.setNoStr(bookDto.getNoStr());
		return book;
	}

	private BookDetail covertBookDetail(BookDto bookDto) {
		BookDetail bookDetail = new BookDetail();
		bookDetail.setBookId(bookDto.getId());
		bookDetail.setDetail(bookDto.getDetail());
		bookDetail.setImgUrl(bookDto.getImgUrl());
		return bookDetail;
	}
}
