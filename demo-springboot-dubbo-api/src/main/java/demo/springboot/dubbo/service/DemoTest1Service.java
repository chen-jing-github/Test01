package demo.springboot.dubbo.service;

import demo.springboot.dubbo.entity.dto.BookDto;
import demo.springboot.dubbo.entity.dto.PageDto;
import demo.springboot.dubbo.entity.vo.BookVo;
import demo.springboot.dubbo.entity.vo.PageDataVo;

public interface DemoTest1Service {

	String serviceMethod1(String msg);

	BookVo addOneBook(BookDto bookDto);

	BookVo addOneBookTestTran(BookDto bookDto);
	
	BookVo queryById(Integer bookId);

	PageDataVo<BookVo> queryBookList(BookDto bookDto, PageDto pageDto);

}
