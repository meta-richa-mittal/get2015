package com.controller;

import java.util.HashMap;
import java.util.Map;

import com.dbHelper.dbService;
import com.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringController {

	@Autowired
	private dbService idbService;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView user() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("myuser", new User());
		return new ModelAndView("index", model);
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("myuser") User user,
			ModelMap model) {
		idbService.insert(user);
		model.addAttribute("name", user.getUserName());
		model.addAttribute("password", user.getPassWord());
		return "result";
	}
}
