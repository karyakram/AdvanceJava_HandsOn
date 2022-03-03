package com.example.demo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

	@RequestMapping("/src/sample")   //it maps the src/sample endpoints to function
	public SampleResponse Sample(@RequestParam(value="name", defaultValue="Restful WebService")String name) {
		SampleResponse res = new SampleResponse();
		res.setId(105);
		res.setName("Your service is: "+name);

		return res;
	}
	@RequestMapping("/goodPage")
	public String goodPage() {
		String s="this is my restful service and here we are using HTTP methods--> for request and response";
		return s;

	}
	
	@RequestMapping(value="/test" , method=RequestMethod.POST)
	public PostResponse Test(@RequestBody PostRequest inputload){
		PostResponse res = new PostResponse();
		res.setId(inputload.getId());
		res.setMessage("Hello"+ inputload.getName());
		res.setRef("Taking response from some friends");
		return res;
	}


}
