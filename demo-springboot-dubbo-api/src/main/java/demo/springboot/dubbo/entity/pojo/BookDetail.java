package demo.springboot.dubbo.entity.pojo;

import java.io.Serializable;

import com.gugusong.sqlmapper.annotation.Entity;
import com.gugusong.sqlmapper.annotation.Id;
import com.gugusong.sqlmapper.annotation.Transient;
import com.gugusong.sqlmapper.strategy.GenerationType;

import demo.springboot.dubbo.entity.dto.TestDto;
import lombok.Data;

@Entity
@Data
public class BookDetail implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	@Id(name = "book_id", strategy = GenerationType.DEFAULT)
	private Long bookId;
	
	private String detail;
	
	private String imgUrl;

	@Transient
	private TestDto testDto;
	
	public BookDetail() {}
	
	public BookDetail(Long bookId, String detail, String imgUrl) {
		this.bookId = bookId;
		this.detail = detail;
		this.imgUrl = imgUrl;
	}

	public BookDetail(Long bookId, String detail, String imgUrl, TestDto testDto) {
		this.bookId = bookId;
		this.detail = detail;
		this.imgUrl = imgUrl;
		this.testDto = testDto;
	}
	
	
}
