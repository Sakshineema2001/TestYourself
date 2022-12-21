package com.exam;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRoles;
import com.exam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamServerApplication implements CommandLineRunner
{

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ExamServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		System.out.println("starting code..........");

//		User user = new User();
//		user.setFirstName("sakshi");
//		user.setLastName("Neema");
//		user.setPassword("abcd");
//		user.setUserName("sakshi2001");
//		user.setEmail("sakshineema2000@gmail.com");
//		user.setProfile("default.png");
//
//		Role role = new Role();
//		role.setRoleId(12l);
//		role.setRoleName("Admin");
//
//		Set<UserRoles> userRolesSet = new HashSet<>();
//		UserRoles userRoles = new UserRoles();
//		userRoles.setRole(role);
//		userRoles.setUser(user);
//
//		userRolesSet.add(userRoles);
//		User user1 = this.userService.createUser(user,userRolesSet);
//		System.out.println(user1.getUserName());
	}

}
