package demo.springboot.dubbo.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gugusong.sqlmapper.Example;
import com.gugusong.sqlmapper.db.ExampleImpl;
import com.gugusong.sqlmapper.springboot.PageData;
import com.gugusong.sqlmapper.springboot.SqlHelpBaseDao;

import demo.springboot.dubbo.entity.dto.BookDto;
import demo.springboot.dubbo.entity.dto.PageDto;
import demo.springboot.dubbo.entity.pojo.Book;
import demo.springboot.dubbo.entity.pojo.BookDetail;
import demo.springboot.dubbo.entity.vo.BookVo;
import demo.springboot.dubbo.entity.vo.PageDataVo;
import demo.springboot.dubbo.perm.entity.dto.RoleDto;
import demo.springboot.dubbo.perm.entity.dto.UserRoleDto;
import demo.springboot.dubbo.perm.entity.vo.RoleVo;
import demo.springboot.dubbo.perm.service.RoleService;
import demo.springboot.dubbo.perm.service.UserRoleService;
import demo.springboot.dubbo.service.DemoTest1Service;

@Service
public class DemoTest1ServiceImpl implements DemoTest1Service {

	@Resource
	private SqlHelpBaseDao dao;
    @Reference(version = "${demo.service.version}")
	private RoleService roleService;
    @Reference(version = "${demo.service.version}")
	private UserRoleService userRoleService;
	

	public PageDataVo<BookVo> queryBookList(BookDto bookDto, PageDto pageDto) {
		Example example = ExampleImpl.newInstance();
		if (bookDto.getVersion() != null) {
			example.and().equals("b.version", bookDto.getVersion());
		} 
		if (bookDto.getBookName() != null && !"".equals(bookDto.getBookName())) {
			example.and().contains("bookName", bookDto.getBookName());
		}
		example.orderByAsc("version").orderByDesc("id").page(pageDto);
		PageData<BookVo> pageDate = (PageData<BookVo>) dao.findPage(example, BookVo.class);
		return new PageDataVo<BookVo>(pageDate);
	}

	public BookVo queryById(Integer bookId) {
		return dao.findOneById(BookVo.class, bookId);
	}

	@Transactional(rollbackFor = Exception.class)
	public BookVo addOneBookTestTran(BookDto bookDto) {
		Book book = this.covertBook(bookDto);
		book = dao.save(book);
		bookDto.setId(book.getId());
		BookDetail bookDetail = this.covertBookDetail(bookDto);
		bookDetail = dao.save(bookDetail);
		BookVo bookVo = dao.findOneByIdForUpdate(BookVo.class, book.getId());
		
		RoleDto roleDto = new RoleDto();
		roleDto.setRoleName("角色" + new Date().getTime());
		RoleVo roleVo = roleService.addOneRole(roleDto);
		
		UserRoleDto userRoleDto = new UserRoleDto();
		userRoleDto.setRoleId(roleVo.getId());
		userRoleService.addOneUserRole(userRoleDto);
		return bookVo;
	}

	@Transactional(rollbackFor = Exception.class)
	public BookVo addOneBook(BookDto bookDto) {
		Book book = this.covertBook(bookDto);
		book = dao.save(book);
		bookDto.setId(book.getId());
		BookDetail bookDetail = this.covertBookDetail(bookDto);
		bookDetail = dao.save(bookDetail);
		BookVo bookVo = dao.findOneByIdForUpdate(BookVo.class, book.getId());
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
	
	public String serviceMethod1(String msg) {
		return "demo.springboot.dubbo.service.impl.DemoTest1ServiceImpl.serviceMethod1.msg=" + msg;
	}
}
