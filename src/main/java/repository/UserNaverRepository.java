package repository;


import model.NaverLoginVo;
import model.UserNaverDto;

public interface UserNaverRepository {
	
	
	public UserNaverDto getNaverUser(NaverLoginVo naver);
	
	public void addNewNaverUser(UserNaverDto newUser);
}
