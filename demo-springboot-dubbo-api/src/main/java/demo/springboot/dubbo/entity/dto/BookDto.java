package demo.springboot.dubbo.entity.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class BookDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String bookName;
	
	private Date createTime;
	
	private Date lastUpdateTime;
	
	private Long number;
	
	private Float price;
	
	private Integer version;
	
	private String noStr;
	
	private String detail;
	
	private String imgUrl;
	
}
