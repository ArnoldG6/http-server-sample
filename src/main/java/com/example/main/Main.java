/**
 @author Arnold González
 @version 1.0
 Main class that initiates the SpringBootApplication
 */
package com.example.main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;




/**
 * Notice that with @RestController annotation in PersonWebService class
 * we tell Spring to inject this class into the application
* */
@SpringBootApplication
@ComponentScan(basePackages = {"com.example.web"}) //Scans dependencies on this package.
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}
