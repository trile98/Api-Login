package PRACTICE.Api_Login.service;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import PRACTICE.Api_Login.model.NaverLoginProfileResponse;
import PRACTICE.Api_Login.model.NaverLoginVo;
import PRACTICE.Api_Login.model.RequestDto;
import PRACTICE.Api_Login.model.User;
import PRACTICE.Api_Login.model.UserNaverDto;
import PRACTICE.Api_Login.repository.UserNaverRepository;
import PRACTICE.Api_Login.repository.UserRepository;
import PRACTICE.Api_Login.repository.UserRoleRepository;

@Service(value = "loginService")
public class LoginServiceImpl implements LoginService {
	
	String clientId = "i4noPSm1dKmpgy1TbR8i";
	String serectId = "BMIjhtjPi9";

	Logger log = Logger.getLogger(LoginServiceImpl.class);
	
	  @Autowired
	    private WebClient webClient;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserNaverRepository userNaverRepo;
	
	@Autowired
	UserRoleRepository userRoleRepo;
	

	public User authenUser(RequestDto req) {
		return userRepo.getUser(req);
		
	}

	public String authorUser(int id) {
		return userRoleRepo.getRole(id);
	}

	 public NaverLoginVo requestNaverLoginAcceccToken(String code, String state, String grant_type){
	        final String uri = UriComponentsBuilder
	                .fromUriString("https://nid.naver.com")
	                .path("/oauth2.0/token")
	                .queryParam("grant_type", grant_type)
	                .queryParam("client_id", this.clientId)
	                .queryParam("client_secret", this.serectId)
	                .queryParam("code", code)
	                .queryParam("state", state)
//	                .queryParam("refresh_token", refesh) // Access_token 갱신시 사용
	                .build()
	                .encode()
	                .toUriString();

	        return webClient
	                .get()
	                .uri(uri)
	                .retrieve()
	                .bodyToMono(NaverLoginVo.class)
	                .block();
	    }

	public int authenNaverUser(UserNaverDto naver) {
		UserNaverDto user = userNaverRepo.getNaverUser(naver);
		log.info(user);
		if(user != null)
			return user.getRole();
		
		return 0;
	}

	@Override
	public UserNaverDto getUserNaverInfo(NaverLoginVo naverLogin) {
		 final String profileUri = UriComponentsBuilder
	                .fromUriString("https://openapi.naver.com")
	                .path("/v1/nid/me")
	                .build()
	                .encode()
	                .toUriString();

	        return webClient
	                .get()
	                .uri(profileUri)
	                .header("Authorization", "Bearer " + naverLogin.getAccess_token())
	                .retrieve()
	                .bodyToMono(NaverLoginProfileResponse.class)
	                .block()
	                .getResponse(); // NaverLoginProfile 은 건네준다.
	}

	@Override
	public void addNaverUser(UserNaverDto user) {
		userNaverRepo.addNewNaverUser(user);
		
	}
}
