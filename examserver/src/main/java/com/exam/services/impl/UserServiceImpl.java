package com.exam.services.impl;

import com.exam.model.User;
import com.exam.model.UserRoles;
import com.exam.repository.RoleRepository;
import com.exam.repository.UserRepository;
import com.exam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	//create user
	@Override
	public User createUser(User user, Set<UserRoles> userRoles) throws Exception
	{
		User local = userRepository.findByUsername(user.getUsername());
		if(local!=null){
			System.out.println("User is already there!!");
			throw new Exception("user alredy present");
		}else {
			//user create
             for(UserRoles ur : userRoles){
				 roleRepository.save(ur.getRole());
			 }
			 user.getUserRoles().addAll(userRoles);
			 local = this.userRepository.save(user);
		}
		return local;
	}

	//getting user by username
	@Override
	public User getUserName(String username)
	{
		return userRepository.findByUsername(username);
	}

	//delete user by id
	@Override
	public void deleteUser(Long id)
	{
		userRepository.deleteById(id);
	}

	//getting all users
	@Override
	public List<User> getAllUser()
	{
		return userRepository.findAll();
	}

	//update user


}
