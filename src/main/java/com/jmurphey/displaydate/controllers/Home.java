package com.jmurphey.displaydate.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/date")
	public String displayDate(Model model) {
		// This is how to create a date format of: Thursday (11) November, 2021
		String pattern = "EEEEE(dd) MMMMM, yyyy";
		SimpleDateFormat simple = new SimpleDateFormat(pattern);
		String date = simple.format(new Date());
		model.addAttribute("date", date);
		return "date.jsp";
	}
	
	@GetMapping("/time")
	public String displayTime(Model model) {
		
//		String pattern = "h:mm a"; hour:minute am/pm :: didnt need this as below does it.
		DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.SHORT);
		String time = dateFormat.format(new Date());
		model.addAttribute("time", time);
		return "time.jsp";
	}
}
