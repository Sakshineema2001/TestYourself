package com.exam.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Role
{
	@Id
	private Long roleId;
	private String roleName;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "role")
	private Set<UserRoles> userRoles = new HashSet<>();

	public Role()
	{
	}

	public Role(Long roleId, String roleName, Set<UserRoles> userRoles)
	{
		this.roleId = roleId;
		this.roleName = roleName;
		this.userRoles = userRoles;
	}

	public Set<UserRoles> getUserRoles()
	{
		return userRoles;
	}

	public void setUserRoles(Set<UserRoles> userRoles)
	{
		this.userRoles = userRoles;
	}

	public Long getRoleId()
	{
		return roleId;
	}

	public void setRoleId(Long roleId)
	{
		this.roleId = roleId;
	}

	public String getRoleName()
	{
		return roleName;
	}

	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}
}
