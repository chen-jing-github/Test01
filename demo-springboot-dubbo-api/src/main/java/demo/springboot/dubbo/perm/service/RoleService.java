package demo.springboot.dubbo.perm.service;

import demo.springboot.dubbo.entity.dto.PageDto;
import demo.springboot.dubbo.entity.vo.PageDataVo;
import demo.springboot.dubbo.perm.entity.dto.RoleDto;
import demo.springboot.dubbo.perm.entity.vo.RoleVo;

public interface RoleService {
	
	RoleVo addOneRoleThrowEx(RoleDto roleDto);
	
	RoleVo addOneRole(RoleDto roleDto);
	
	RoleVo queryById(Integer roleId);

	PageDataVo<RoleVo> queryRoleList(RoleDto roleDto, PageDto pageDto);

}
