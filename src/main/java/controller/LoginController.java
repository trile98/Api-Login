package controller;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.RequestDto;
import model.ResponseDto;
import model.User;
import service.LoginService;

@RestController
public class LoginController {
	

	@Autowired
	ResponseDto response;
	
	@Autowired
	LoginService loginService;
	
	Logger log = Logger.getLogger(LoginController.class);

	@RequestMapping(path = "/login", method= {RequestMethod.POST, RequestMethod.GET})
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
	
	@RequestMapping(path = "/loginNaver", method= RequestMethod.GET)
	void loginGetProcess(HttpServletRequest request , HttpServletResponse response) throws IOException {
		log.info("====="+request.getRequestURL().toString() + "?" + request.getQueryString()+"==");
		// Generate random strings to be used as a state token.
		String state = generateState();
		// Store the generated state token in the session or separate storage.
		request.getSession().setAttribute("state", state);
		log.info("====loginGetproccess==="+state);
	}
	
	@RequestMapping(path = "/author", method= RequestMethod.GET)
	void loginAuthorGetProcess(HttpServletRequest request ) {
		log.info("=========="+request.getRequestURL().toString() + "?" + request.getQueryString());
	}
	
	// Generate a state token to prevent CSRF attacks.
	// The generated state token should be stored in the session for further verification.
	public String generateState()
	{
	 SecureRandom random = new SecureRandom();
	 return new BigInteger(130, random).toString(32);
	}
	
	
	@RequestMapping(path = "/error", method= RequestMethod.GET)
	ResponseDto loginErrGetProcess() {
//		log.info("======="+error+"===="+state+"===="+errDes+"====");
			response.setSuccess(false);
			response.setMessage("login fail");
		
		return response;
	}
}
