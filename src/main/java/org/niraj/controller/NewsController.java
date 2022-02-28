package org.niraj.controller;

import java.util.ArrayList;

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
		
		ArrayList publicationList = new ArrayList<String>();
		publicationList.add("www.patnaInfo.com");
		publicationList.add("www.hindustanTimes.com");
		publicationList.add("www.khojo.online");
		publicationList.add("www.newsdekho.in");
				
		return "welcome to Bihar news API call";
	}
		
}
