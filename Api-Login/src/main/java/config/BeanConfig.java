package config;

import org.springframework.context.annotation.*;

import service.LoginService;
import service.LoginServiceImpl;

@Configuration
public class BeanConfig {
	
	@Bean
	public LoginService loginService() {
		return new LoginServiceImpl();
	}

}
