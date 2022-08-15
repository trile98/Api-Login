package PRACTICE.Api_Login;

import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import controller.LoginController;

/**
 * Hello world!
 *
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan({"config", "controller", "model", "respository"})
public class App 
{
    public static void main( String[] args )
    {
    	BasicConfigurator.configure();
        SpringApplication.run(App.class, args);
        
    }
}
