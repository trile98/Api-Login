package controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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

	@PostMapping("/login")
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
}
