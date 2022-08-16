package controller;

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

import model.NaverLoginVo;
import model.RequestDto;
import model.ResponseDto;
import model.User;
import model.UserNaverDto;
import service.LoginService;

@RestController
public class LoginController {
	@Autowired
	ResponseDto response;
	
	@Autowired
	LoginService loginService;
	
	Logger log = Logger.getLogger(LoginController.class);

	@RequestMapping(path = "/login", method= {RequestMethod.POST})
	ResponseDto loginProcess(@RequestBody RequestDto req) {
		log.info("======="+req.getUsername());
		if(req.getUsername() != null && req.getPassword()!=null){
			
			int roleId =loginService.authenUser(req);
			
			if(roleId == 0) {
				response.setSuccess(false);
				response.setMessage("Username/ Password is not exist");
			}else {
				String role = loginService.authorUser(roleId);
				response.setSuccess(true);
				response.setMessage("Welcome "+ role);
			}
		}else {
			response.setSuccess(false);
			response.setMessage("Missing Username and Password");
		}
		return response;
	}
	
	@RequestMapping(path = "/login", method= {RequestMethod.GET})
	ResponseDto loginProcess(@RequestParam("username") String username, @RequestParam("password") String password) {
		log.info("======="+username);
		if(username != null && username != "" && password!=null && password != ""){
			
			RequestDto req = new RequestDto();
			req.setUsername(username);
			req.setPassword(password);
			
			int roleId =loginService.authenUser(req);
			
			if(roleId == 0) {
				response.setSuccess(false);
				response.setMessage("Username/ Password is not exist");
			}else {
				String role = loginService.authorUser(roleId);
				response.setSuccess(true);
				response.setMessage("Welcome "+ role);
			}
		}else {
			response.setSuccess(false);
			response.setMessage("Missing Username and Password");
		}
		
		return response;
	}
	
	
	@RequestMapping(path = "/loginNaver", method= RequestMethod.GET)
	String loginGetProcess(HttpServletRequest request ) throws IOException {
		
		
		NaverLoginVo naverLogin = loginService.requestNaverLoginAcceccToken(request.getParameter("code"), request.getParameter("state"), "authorization_code");
		
		log.info(naverLogin.getAccess_token());
		
		int roleId =loginService.authenNaverUser(naverLogin);
		
		if(roleId == 0) {
			UserNaverDto newUser = loginService.getUserNaverInfo(naverLogin);
			newUser.setAccessToken(naverLogin.getAccess_token());
			loginService.addNaverUser(newUser);
			
			response.setSuccess(true);
			response.setMessage("Add new naver user successfully! Welcome User");
			
		}else {
			String role = loginService.authorUser(roleId);
			response.setSuccess(true);
			response.setMessage("Welcome "+ role);
		}
		
		log.info(response.getMessage());
		
		return response.getMessage();
	}
	
	@RequestMapping(path = "/error", method= RequestMethod.GET)
	ResponseDto loginErrGetProcess() {
//		log.info("======="+error+"===="+state+"===="+errDes+"====");
			response.setSuccess(false);
			response.setMessage("login fail");
		
		return response;
	}
}
