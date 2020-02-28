package com.ibm.training;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	UserService service;

	@RequestMapping("/users")
	List<User> getUsers(){
		return service.getUsers();
	}
	
	@RequestMapping("/users/{id}")
	User getUserById(@PathVariable int id){
		return service.getUserById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/users/{userID}/{userName}/{userAddress}")
	void addUserDetails(@PathVariable int userID, @PathVariable String userName, @PathVariable String userAddress){
		service.addUserDetails(userID, userName, userAddress);
	}
	
	@RequestMapping(method = RequestMethod.POST, value ="/users/{userID}/{userAddress}")
	void updateUserDetails(@PathVariable int userID, @PathVariable String userAddress){
		service.updateUserDetails(userID, userAddress);;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{userID}")
	void deleteUserDetails(@PathVariable int userID){
		service.deleteUserDetails(userID);
	}
}
