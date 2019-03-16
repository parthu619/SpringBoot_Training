package com.example.demo;
import org.springframework.web.bind.annotation.RequestMapping;
public class Login {
	@RequestMapping("/")
	public String retrunName() {
		System.out.println("Hello Parthu");
		return "HI parthu" ;
	}	
}
