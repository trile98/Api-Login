package config;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.*;

import service.LoginService;
import service.LoginServiceImpl;

@Configuration
public class BeanConfig {
	
	@Bean
	public LoginService loginService() {
		return new LoginServiceImpl();
	}
	
//	@Bean
//	public ConfigurableServletWebServerFactory webServerFactory() {
//	    TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
//	    factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
//	        public void customize(Connector connector) {
//	            connector.setProperty("relaxedQueryChars", "|{}[]");
//	        }
//	    });
//	    return factory;
//	}

}
