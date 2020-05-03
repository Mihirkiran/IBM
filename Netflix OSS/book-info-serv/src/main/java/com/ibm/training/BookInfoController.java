package com.ibm.training;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/books")
public class BookInfoController {
	
	@Autowired
	BookService service;
	
	@Autowired
	RestTemplate template;

	@RequestMapping("/{id}")
	Book getBookInfo(@PathVariable int id) {
		return service.getBookInfo(id);
	}
	
	
	@RequestMapping("/all")
	List<Object> getAllBookData(){
		
		
		return service.getAllBookData();
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/item")
	void addBookIntoCatalog(@RequestBody Book book){
		service.addBook(book);

	}
	
	
	
	
	
	
	
}
