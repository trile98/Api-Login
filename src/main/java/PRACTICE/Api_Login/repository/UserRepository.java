package PRACTICE.Api_Login.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import PRACTICE.Api_Login.model.NaverLoginVo;
import PRACTICE.Api_Login.model.RequestDto;
import PRACTICE.Api_Login.model.User;

public interface UserRepository {
	
	public User getUser(RequestDto req);
}
