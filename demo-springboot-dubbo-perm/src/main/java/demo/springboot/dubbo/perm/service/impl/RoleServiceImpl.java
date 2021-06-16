package demo.springboot.dubbo.perm.service.impl;

import javax.annotation.Resource;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gugusong.sqlmapper.Example;
import com.gugusong.sqlmapper.db.ExampleImpl;
import com.gugusong.sqlmapper.springboot.PageData;
import com.gugusong.sqlmapper.springboot.SqlHelpBaseDao;

import demo.springboot.dubbo.common.exception.CustomException;
import demo.springboot.dubbo.entity.dto.PageDto;
import demo.springboot.dubbo.entity.vo.PageDataVo;
import demo.springboot.dubbo.perm.entity.dto.RoleDto;
import demo.springboot.dubbo.perm.entity.pojo.Role;
import demo.springboot.dubbo.perm.entity.vo.RoleVo;
import demo.springboot.dubbo.perm.service.RoleService;

@Service(version = "${demo.service.version}", interfaceClass = RoleService.class)
public class RoleServiceImpl implements RoleService {
	
	@Resource
	private SqlHelpBaseDao dao;

	@Transactional
	public RoleVo addOneRole(RoleDto roleDto) {
		Role role = dao.save(this.convertRole(roleDto));
		if (role.getId() != null) {
			return dao.findOneByIdForUpdate(RoleVo.class, role.getId());
		}
		return null;
	}

	@Transactional
	public RoleVo addOneRoleThrowEx(RoleDto roleDto) {
		Role role = dao.save(this.convertRole(roleDto));
		throw new CustomException("抛出自定义异常：addOneRoleThrowEx");
	}
	
	public RoleVo queryById(Integer roleId) {
		return dao.findOneById(RoleVo.class, roleId);
	}

	public PageDataVo<RoleVo> queryRoleList(RoleDto roleDto, PageDto pageDto) {
		Example example = ExampleImpl.newInstance();
		if (roleDto.getRoleName() != null && !"".equals(roleDto.getRoleName())) {
			example.and().contains("r.roleName", roleDto.getRoleName());
		}
		example.orderByAsc("id").page(pageDto);
		PageData<RoleVo> pageDate = dao.findPage(example, RoleVo.class);
		return new PageDataVo<RoleVo>(pageDate);
	}
	
	private Role convertRole(RoleDto roleDto) {
		Role role = new Role();
		role.setRoleName(roleDto.getRoleName());
		return role;
	}

}
