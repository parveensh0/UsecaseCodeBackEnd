package com.library.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *  Application starting point.
 *  
 * @author esmapen
 *
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.library.demo.controller"})
public class DemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
