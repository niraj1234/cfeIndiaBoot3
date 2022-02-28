package org.niraj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
public class NewsController {


	@RequestMapping(value = "/welcome" , method = RequestMethod.GET)
	public String getNews() {
		
		for (int i = 0 ; i<5 ;i++ ) {
			System.out.println("News Publication calling => " + i);
		}
		return "welcome to Bihar news API call";
	}
		
}
