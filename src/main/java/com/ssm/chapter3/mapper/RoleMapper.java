package main.java.com.ssm.chapter3.mapper;
import main.java.com.ssm.chapter3.pojo.Role;

import java.util.List;

public interface RoleMapper {
	public int insertRole(Role role);
	public int deleteRole(Long id);
	public int updateRole(Role role);
	public Role getRole(Long id);
	public List<Role> findRoles(String roleName);
}