package demo.springboot.dubbo.entity.vo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.gugusong.sqlmapper.annotation.vo.Join;
import com.gugusong.sqlmapper.annotation.vo.PropertyMapping;
import com.gugusong.sqlmapper.annotation.vo.VOBean;

import demo.springboot.dubbo.entity.pojo.Book;
import demo.springboot.dubbo.entity.pojo.BookDetail;
import lombok.Data;

@VOBean(mainPo = Book.class, entityAlias = "b")
@Join(joinType = Join.LEFT_JOIN_TYPE, po = BookDetail.class, entityAlias = "bd", joinConditions = "{b.id}= {bd.bookId}")
@Data
public class BookVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String bookName;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date lastUpdateTime;
	
	private Long number;
	
	private Float price;
	
	private Integer version;
	
	private Long noStr;

	@PropertyMapping(originalName = "bd.bookId")
	private Integer bookId;
	
	@PropertyMapping(originalName = "bd.bookId")
	private Integer bookDetailId;

	@PropertyMapping(originalName = "bd.detail")
	private String detail;

	@PropertyMapping(originalName = "bd.imgUrl")
	private String imgUrl;
	
}
