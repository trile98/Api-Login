package PRACTICE.Api_Login.repository;


import PRACTICE.Api_Login.model.NaverLoginVo;
import PRACTICE.Api_Login.model.UserNaverDto;

public interface UserNaverRepository {
	
	
	public UserNaverDto getNaverUser(UserNaverDto naver);
	
	public void addNewNaverUser(UserNaverDto newUser);
}
