package service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import model.RequestDto;
import model.User;
import repository.UserRepository;
import repository.UserRoleRepository;

@Service(value = "loginService")
public class LoginServiceImpl implements LoginService {

	Logger log = Logger.getLogger(LoginServiceImpl.class);
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserRoleRepository userRoleRepo;
	

	public int authenUser(RequestDto req) {
		User user = userRepo.getUser(req);
		log.info(user);
		if(user != null)
			return user.getRole();
		
		return 0;
	}

	public String authorUser(int id) {
		return userRoleRepo.getRole(id);
	}

}
