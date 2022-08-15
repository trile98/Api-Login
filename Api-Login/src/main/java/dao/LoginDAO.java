package dao;

import java.sql.SQLException;

import model.User;

public interface LoginDAO {
	User getUser(User user) throws SQLException;
}
