package com.saitej.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.saitej.model.User;
import com.saitej.utils.DBUtil;

public class UserRepository {

	private static final String INSERT = "INSERT INTO USER_TBL(USER_NAME,PASSWORD,EMAIL,MOBILE_NUMBER,TIMESTAMP) VALUES (?,?,?,?,?)";
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	public int saveUser(User user) {
		System.out.println("UserRepository.saveUser()");
		int count = 0;
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(INSERT);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPass());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getContact());
			ps.setString(5, LocalDateTime.now().format(formatter));
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

}
