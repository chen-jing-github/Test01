package demo.springboot.dubbo.perm.entity.vo;

import java.io.Serializable;
import java.util.Date;

import com.gugusong.sqlmapper.annotation.vo.Join;
import com.gugusong.sqlmapper.annotation.vo.VOBean;

import demo.springboot.dubbo.perm.entity.pojo.Role;
import demo.springboot.dubbo.perm.entity.pojo.UserRole;
import lombok.Data;

@Data
@VOBean(entityAlias = "ur", mainPo = UserRole.class)
@Join(entityAlias = "r", po = Role.class, joinType = Join.INNER_JOIN_TYPE, joinConditions = "{ur.roleId} = {r.id}")
public class UserRoleVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private Integer userId;

	private Integer roleId;

	private Integer version;
	
	private String roleName;
	
	private Date createTime;
	
	private Date lastUpdTime;
	
}
