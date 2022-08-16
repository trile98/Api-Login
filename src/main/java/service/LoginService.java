package service;

import java.util.Map;

import model.NaverLoginVo;
import model.RequestDto;
import model.User;
import model.UserNaverDto;

public interface LoginService {
	
	int authenUser(RequestDto req);
	String authorUser(int id);
	NaverLoginVo requestNaverLoginAcceccToken(String code, String state, String grant_type);
	
	
	int authenNaverUser(NaverLoginVo naver);
	
	UserNaverDto getUserNaverInfo(NaverLoginVo naverLogin);
	
	void addNaverUser(UserNaverDto user);
}
