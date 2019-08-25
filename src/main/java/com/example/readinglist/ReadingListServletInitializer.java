package com.example.readinglist;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class ReadingListServletInitializer extends SpringBootServletInitializer{

	@Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder builder){
		return builder.sources(ReadinglistApplication.class);
	}
	
}
