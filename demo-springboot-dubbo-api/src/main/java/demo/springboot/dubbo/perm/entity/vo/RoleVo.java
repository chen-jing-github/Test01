package demo.springboot.dubbo.perm.entity.vo;

import java.io.Serializable;
import java.util.Date;

import com.gugusong.sqlmapper.annotation.vo.VOBean;

import demo.springboot.dubbo.perm.entity.pojo.Role;
import lombok.Data;

@Data
@VOBean(entityAlias = "r", mainPo = Role.class)
public class RoleVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String roleName;
	
	private Date createTime;
	
	private Date lastUpdTime;
	
}
