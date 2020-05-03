package com.ibm.training;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class BookService {
	
	@Autowired
	RestTemplate template;

	@HystrixCommand(fallbackMethod = "stillWorks")
	public Book getBookInfo(Integer id) {
		String anotherServiceUrl = "http://bookcatalogservice/catalog/" + Integer.toString(id);
		return template.getForObject(anotherServiceUrl, Book.class);
	}

	@HystrixCommand(fallbackMethod = "stillWorks")
	public List<Object> getAllBookData() {
		String anotherServiceUrl = "http://bookcatalogservice/catalog/all";
		
		Object []dataFromOtherService = template.getForObject(anotherServiceUrl, Object[].class);
		
		return Arrays.asList(dataFromOtherService);
	}
	

	
	@HystrixCommand(fallbackMethod = "stillWorks1")
	public void addBook(Book book) {
		String urlToHit = "http://bookcatalogservice/catalog/item";
		
		template.postForObject(urlToHit, book, Object.class);
		
	}
	
	public List<Object> stillWorks(){
		return Arrays.asList(
				new Book("Keep Going", "We should never stop learning", 765)
				);
	}
	
	public void stillWorks1(Book book){
		System.out.println("Error!!!");
	}
}
