package demo.springboot.dubbo.entity.pojo;

import java.io.Serializable;
import java.util.Date;

import com.gugusong.sqlmapper.annotation.Column;
import com.gugusong.sqlmapper.annotation.Entity;
import com.gugusong.sqlmapper.annotation.Id;
import com.gugusong.sqlmapper.annotation.Transient;
import com.gugusong.sqlmapper.annotation.Version;
import com.gugusong.sqlmapper.strategy.GenerationType;

import lombok.Data;

@Entity
@Data
public class Book implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	@Id(name = "id", strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String bookName;
	
	private Date createTime = new Date();
	
	@Column(name = "last_upd_time")
	private Date lastUpdateTime;
	
	private Long number;
	
	private Float price;
	
	@Version
	private Integer version;
	
	@Column(name = "no", comments = "批号编号", dateType = "int")
	private String noStr;
	
}
