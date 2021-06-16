package demo.springboot.dubbo.perm.entity.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class UserRoleDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private Integer userId;

	private Integer roleId;

	private Integer version;
	
	private Date createTime;
	
	private Date lastUpdTime;
	
}
