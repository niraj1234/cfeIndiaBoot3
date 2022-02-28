package org.niraj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
public class NewsController {


	@RequestMapping(value = "/welcome" , method = RequestMethod.GET)
	public String getNews() {
		return "welcome to Bihar news API call";
	}
		
}
