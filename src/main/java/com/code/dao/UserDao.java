package com.code.dao;

import com.code.entity.User;
import com.code.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

public class UserDao {
	/** sql语句 */
	private String sql = "";
	
	/** QueryRunner */
	private QueryRunner queryRunner = JdbcUtils.getQueryRunnner();
	
	public User login(String username, String password) {
		sql = "SELECT userId, username, `password`, sex, height, weight, registerTime, `status` FROM `user` WHERE username = ? AND `password` = ?";
		try {
			return queryRunner.query(sql, new BeanHandler<User>(User.class), username, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean isExist(String username) {
		sql = "SELECT userId FROM user WHERE username = ?";
		try {
			return queryRunner.query(sql, new ScalarHandler<Integer>(), username) != null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean register(User user) {
		sql = "INSERT INTO user (username, `password`, sex, height, weight) VALUES (?, ?, ?, ?, ?);";
		try {
			return queryRunner.update(sql, user.getUsername(), user.getPassword(), user.getSex(), user.getHeight(), user.getWeight()) > 0;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean updateUser(User user) {
		sql = "UPDATE user set sex = ?, height = ?, weight = ? WHERE username = ?;";
		try {
			return queryRunner.update(sql, user.getSex(), user.getHeight(), user.getWeight(), user.getUsername()) > 0;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}