package com.wykd.it.movie.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;
	
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	
	@RequestMapping("/userInfo")
	public String restUserInfo() {
		String url = "http://localhost:8001/index";
		
		ResponseEntity entity = this.restTemplate.getForEntity(url, String.class, "");
		String body = (String) entity.getBody();
		System.out.println(JSON.toJSONString(entity));
		return body;
	}
}
