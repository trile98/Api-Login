package repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import model.RequestDto;
import model.User;

public interface UserRepository {
	
	public User getUser(RequestDto req);
}
