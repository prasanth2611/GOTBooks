package com.example.got.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

	@RequestMapping("/")
	public  String home(){
		return "index";
	}

	@RequestMapping("/books")
	public String books() {

		return "books";
	}

	@RequestMapping("/book-details")
	public  String bookDetails(){
		return  "book-details";
	}

}
