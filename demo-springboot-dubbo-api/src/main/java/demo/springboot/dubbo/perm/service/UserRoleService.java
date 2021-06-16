package demo.springboot.dubbo.perm.service;

import demo.springboot.dubbo.entity.dto.PageDto;
import demo.springboot.dubbo.entity.vo.PageDataVo;
import demo.springboot.dubbo.perm.entity.dto.UserRoleDto;
import demo.springboot.dubbo.perm.entity.vo.UserRoleVo;

public interface UserRoleService {

	UserRoleVo addOneUserRoleThrowEx(UserRoleDto userRoleDto);

	UserRoleVo addOneUserRole(UserRoleDto userRoleDto);
	
	UserRoleVo queryById(Integer userRoleId);

	PageDataVo<UserRoleVo> queryUserRoleList(UserRoleDto userRoleDto, PageDto pageDto);

}
