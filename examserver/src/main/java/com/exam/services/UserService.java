package com.exam.services;

import com.exam.model.User;
import com.exam.model.UserRoles;

import java.util.List;
import java.util.Set;

public interface UserService
{
	//create User
	public User createUser(User user, Set<UserRoles> userRoles) throws Exception;

	//get user
	public User getUserName(String userName);

	//delete user
	public void deleteUser(Long id);
	//get All user
	public List<User> getAllUser();

	//update user

}
