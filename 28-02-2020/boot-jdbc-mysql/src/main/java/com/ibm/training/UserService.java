package com.ibm.training;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserDao dao;

	List<User> getUsers(){
		return dao.getUsers();
	}

	public User getUserById(int id) {
		return dao.getUserById(id);
	}
	
	public void deleteUserDetails(int id) {
		dao.deleteUserDetails(id);
	}
	
	public void addUserDetails(int userID, String userName, String userAddress) {
		dao.addUserDetails(userID, userName, userAddress);
	}
	
	public void updateUserDetails(int userID, String userAddress) {
		dao.updateUserDetails(userID, userAddress);
	}
}
