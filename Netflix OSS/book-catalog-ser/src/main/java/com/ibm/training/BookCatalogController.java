package com.ibm.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("catalog")
public class BookCatalogController {
	
	@Autowired
	BookCatalogService service;

	
	@RequestMapping(method = RequestMethod.POST, value =  "/item")
	void addUser(@RequestBody Book book) {
		service.addBook(book);
	}
	
	@RequestMapping("/all")
	List<Book> getBooks(){
		return service.getBooks();
	}
	
	@RequestMapping("/{id}")
	Optional<Book> getUserByID(@PathVariable int id) {
		return service.getBookByID(id);
	}
	

	
	
	
	
}
