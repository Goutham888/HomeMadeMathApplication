package com.testing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.data.User;
import com.login.dao.LoginDataAccessObject;

public class GetAllTest {

	public static void main(String[] args) {
		LoginDataAccessObject ldao = new LoginDataAccessObject();
		List<User> users = ldao.getAllUsers();
		
		for(User user: users) {
			System.out.println(user.getUserName());
		}
		
		//Connection con = utilMethods.establishConnection();
		/*PreparedStatement getAll = con.prepareStatement(sqlGetAll);
		ResultSet rs = getAll.executeQuery();
		User temp = new User();
		while(rs.next()) {
			temp.setFirstName(rs.getString("firstname"));
			temp.setLastName(rs.getString("lastname"));
			temp.setPasscode(rs.getString("passcode"));
			temp.setUserName(rs.getString("username"));
			users.add(temp);
			temp = new User();
		}*/
		
	}

}
