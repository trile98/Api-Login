package service;

import model.RequestDto;
import model.User;

public interface LoginService {
	
	int authenUser(RequestDto req);
	String authorUser(int id);
}
