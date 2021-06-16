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
import demo.springboot.dubbo.perm.entity.dto.UserRoleDto;
import demo.springboot.dubbo.perm.entity.pojo.Role;
import demo.springboot.dubbo.perm.entity.pojo.UserRole;
import demo.springboot.dubbo.perm.entity.vo.RoleVo;
import demo.springboot.dubbo.perm.entity.vo.UserRoleVo;
import demo.springboot.dubbo.perm.service.UserRoleService;

@Service(version = "${demo.service.version}",interfaceClass = UserRoleService.class)
public class UserRoleServiceImpl implements UserRoleService {
	
	@Resource
	private SqlHelpBaseDao dao;

	@Transactional
	public UserRoleVo addOneUserRole(UserRoleDto userRoleDto) {
		UserRole userRole = dao.save(this.convertUserRole(userRoleDto));
		if (userRole.getId() != null) {
			return dao.findOneByIdForUpdate(UserRoleVo.class, userRole.getId());
		}
		return null;
	}

	@Transactional
	public UserRoleVo addOneUserRoleThrowEx(UserRoleDto userRoleDto) {
		UserRole userRole = dao.save(this.convertUserRole(userRoleDto));
		throw new CustomException("抛出自定义异常：addOneUserRoleThrowEx");
	}

	public UserRoleVo queryById(Integer roleId) {
		return dao.findOneById(UserRoleVo.class, roleId);
	}

	public PageDataVo<UserRoleVo> queryUserRoleList(UserRoleDto userRoleDto, PageDto pageDto) {
		Example example = ExampleImpl.newInstance();
		if (userRoleDto.getVersion() != null) {
			example.and().equals("ur.version", userRoleDto.getVersion());
		} 
		if (userRoleDto.getRoleId() != null && !"".equals(userRoleDto.getRoleId())) {
			example.and().equals("ur.roleId", userRoleDto.getRoleId());
		}
		if (userRoleDto.getUserId() != null && !"".equals(userRoleDto.getUserId())) {
			example.and().equals("ur.userId", userRoleDto.getUserId());
		}
		example.page(pageDto);
		PageData<UserRoleVo> pageDate = dao.findPage(example, UserRoleVo.class);
		return new PageDataVo<UserRoleVo>(pageDate);
	}
	
	private UserRole convertUserRole(UserRoleDto userRoleDto) {
		UserRole userRole = new UserRole();
		userRole.setRoleId(userRoleDto.getRoleId());
		userRole.setUserId(userRoleDto.getUserId());
		return userRole;
	}
	
}
