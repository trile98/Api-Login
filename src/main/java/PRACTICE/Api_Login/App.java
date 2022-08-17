package PRACTICE.Api_Login;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import PRACTICE.Api_Login.controller.LoginController;

/**
 * Hello world!
 *
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class App 
{
    public static void main( String[] args )
    {
    	BasicConfigurator.configure();
        SpringApplication.run(App.class, args);
        
    }
}
