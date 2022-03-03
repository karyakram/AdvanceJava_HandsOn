package com.demo.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootJdbcController {
	@Autowired
	JdbcTemplate jdbc;
	
	@RequestMapping("/insertData")
	public String idx() {
		jdbc.execute("insert into batch7 values (101,'abc')");
		return "data stored";
	}
	
	@RequestMapping("/getData")
	public String getData() {
		jdbc.execute("select *from batch7");
		return "data is here";
	}
	
	

}
