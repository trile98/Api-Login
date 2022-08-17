package PRACTICE.Api_Login.service;

import java.util.Map;

import PRACTICE.Api_Login.model.NaverLoginVo;
import PRACTICE.Api_Login.model.RequestDto;
import PRACTICE.Api_Login.model.User;
import PRACTICE.Api_Login.model.UserNaverDto;

public interface LoginService {
	
	User authenUser(RequestDto req);
	String authorUser(int id);
	NaverLoginVo requestNaverLoginAcceccToken(String code, String state, String grant_type);
	
	
	int authenNaverUser(UserNaverDto naver);
	
	UserNaverDto getUserNaverInfo(NaverLoginVo naverLogin);
	
	void addNaverUser(UserNaverDto user);
}
