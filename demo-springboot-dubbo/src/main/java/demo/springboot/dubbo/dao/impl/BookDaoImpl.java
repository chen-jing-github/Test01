package demo.springboot.dubbo.dao.impl;

import javax.annotation.Resource;

import com.gugusong.sqlmapper.springboot.SqlHelpBaseDao;

import demo.springboot.dubbo.dao.BookDao;
import demo.springboot.dubbo.entity.pojo.Book;

public class BookDaoImpl implements BookDao {

	@Resource
	private SqlHelpBaseDao dao;

	public Book addOneBook(Book book) {
		book = dao.save(book);
		return book;
	}

}
