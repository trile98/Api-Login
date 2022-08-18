package PRACTICE.Api_Login.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import PRACTICE.Api_Login.model.NaverLoginVo;
import PRACTICE.Api_Login.model.RequestDto;
import PRACTICE.Api_Login.model.ResponseDto;
import PRACTICE.Api_Login.model.User;
import PRACTICE.Api_Login.model.UserNaverDto;
import PRACTICE.Api_Login.service.LoginService;

@RestController
public class LoginController {
	@Autowired
	ResponseDto response;
	
	@Autowired
	LoginService loginService;
	
	Logger log = Logger.getLogger(LoginController.class);


	
	@RequestMapping(path = "/login", method= {RequestMethod.GET})
	ResponseDto loginProcess(@RequestParam("username") String username, @RequestParam("password") String password) {
		log.info("======="+username);
		if(username != null && username != "" && password!=null && password != ""){
			
			RequestDto req = new RequestDto();
			req.setUsername(username);
			req.setPassword(password);
			
			User user =loginService.authenUser(req);
			
			if(user == null) {
				response.setSuccess(false);
				response.setMessage("Username/ Password is not exist");
			}else {
				String role = loginService.authorUser(user.getRole());
				response.setSuccess(true);
				response.setMessage("Welcome "+ user.getUsername()+"! You are an "+role);
			}
		}else {
			response.setSuccess(false);
			response.setMessage("Missing Username and Password");
		}
		
		return response;
	}
	
	
	@RequestMapping(path = "/loginNaver", method= RequestMethod.GET)
	String loginNaverProcess (@RequestParam(name = "code", required = false) String code, @RequestParam(name = "error", required = false) String error, @RequestParam(name = "state") String state, @RequestParam(name ="error_description", required= false) String descrip) throws IOException {
		
		if(error != null) {
		
			NaverLoginVo naverLogin = loginService.requestNaverLoginAcceccToken(code, state, "authorization_code");
			
			log.info(naverLogin.getAccess_token());
			
			
			UserNaverDto naverUser = loginService.getUserNaverInfo(naverLogin);
			naverUser.setAccessToken(naverLogin.getAccess_token());
			
			int roleId =loginService.authenNaverUser(naverUser);
			
	
			
			
			if(roleId == 0) {

				loginService.addNaverUser(naverUser);
	
				response.setSuccess(true);
				response.setMessage("Add new naver user successfully! Welcome User");
				
			}else {
				String role = loginService.authorUser(roleId);
				response.setSuccess(true);
				response.setMessage("Welcome "+ role);
			}
		}else {
			response.setSuccess(false);
			response.setMessage("Login failed! Error: "+error+"---"+descrip);
		}
		
		log.info(response.getMessage());
		
		return response.getMessage();
	}
	
	
}
