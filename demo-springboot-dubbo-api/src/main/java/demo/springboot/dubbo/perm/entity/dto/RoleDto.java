package demo.springboot.dubbo.perm.entity.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class RoleDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String roleName;
	
	private Date createTime;
	
	private Date lastUpdTime;
	
}
