package demo.springboot.dubbo.perm.entity.pojo;

import java.io.Serializable;
import java.util.Date;

import com.gugusong.sqlmapper.annotation.Column;
import com.gugusong.sqlmapper.annotation.Entity;
import com.gugusong.sqlmapper.annotation.Id;
import com.gugusong.sqlmapper.annotation.Transient;
import com.gugusong.sqlmapper.strategy.GenerationType;

import demo.springboot.dubbo.perm.entity.dto.RoleDto;
import lombok.Data;

@Data
@Entity
public class Role implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	@Id(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String roleName;
	
	private Date createTime = new Date();
	
	private Date lastUpdTime = new Date();
	
	public Role() {}
	
	public Role(String roleName) {
		this.roleName = roleName;
	}
	
}
