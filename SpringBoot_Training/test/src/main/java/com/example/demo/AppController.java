package com.example.demo;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController implements org.springframework.web.servlet.mvc.Controller{
	@RequestMapping(path = "list")
	public ModelAndView handleRequest(HttpServletRequest req , HttpServletResponse res) throws Exception{
		ModelAndView mav = new ModelAndView();
		ArrayList<String> names = new ArrayList();
		names.add("parthu");
		names.add("sarathi");
		names.add("john cena");
		names.add("yoyo");
		mav.addObject(names);
		mav.addObject("name","parthu");
		mav.setViewName("success");
		return mav;
	}

}
