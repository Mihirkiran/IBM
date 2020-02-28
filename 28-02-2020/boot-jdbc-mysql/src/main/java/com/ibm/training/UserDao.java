package com.ibm.training;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	@Autowired
	JdbcTemplate template;

	public List<User> getUsers() {
		
		return template.query("select * from user_details", new UserMapper());
	}

	public User getUserById(int id) {
		return template.queryForObject("select * from user_details where userID = ?",
				new Object[] {id},
				new UserMapper());
	}
	
	public void deleteUserDetails(int id) {
		template.update("delete from user_details where userID = ?",
				new Object[] {id});
	}
	
	public void addUserDetails(int userID, String userName, String userAddress) {
		template.update("insert into user_details values (?, ?, ?)",
				new Object[] {userID, userName, userAddress});
	}
	
	public void updateUserDetails(int userID, String userAddress) {
		template.update("update user_details set userAddress = ? where userID = ?",
				new Object[] {userAddress, userID});
	}
	
	class UserMapper implements RowMapper<User>{

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setUserID(rs.getInt("userID"));
			user.setUserName(rs.getString("userName"));
			user.setUserAddress(rs.getString("userAddress"));
			return user;
		}
		
	}

}
