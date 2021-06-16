package demo.springboot.dubbo.entity.dto;

import java.io.Serializable;

import demo.springboot.dubbo.entity.pojo.BookDetail;
import lombok.Data;

@Data
public class TestDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	
	private BookDetail bookDetail;
	
	public TestDto() {}
	
	public TestDto(String id, BookDetail bookDetail) {
		this.id = id;
		this.bookDetail = bookDetail;
	}
	
}
